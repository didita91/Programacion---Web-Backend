package py.pol.una.ii.pw.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.inject.Default;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import py.pol.una.ii.pw.example.ProductoDuplicadoExample;
import py.pol.una.ii.pw.mapper.ProductoDuplicadoMapper;
import py.pol.una.ii.pw.mapper.ProductoMapper;
import py.pol.una.ii.pw.model.Producto;
import py.pol.una.ii.pw.model.ProductoDuplicado;
import py.pol.una.ii.pw.model.ProgramacionSqlSessionFactory;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
public class ProductoService {
	@Default
	@EJB
	private ProductoService productoService;
	
	public void crear(List<Producto> producto)
			throws SQLIntegrityConstraintViolationException {
		Iterator<Producto> productoIterator = producto.iterator();

		while (productoIterator.hasNext()) {
			productoService.verificarDuplicado(productoIterator.next());
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void verificarDuplicado(Producto producto) {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ProductoMapper mapper = session.getMapper(ProductoMapper.class);
			mapper.insert(producto);
			session.commit();
		} catch (Exception e) {
			productoService.productoDuplicadoCarga(producto);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void productoDuplicadoCarga(Producto producto) {
		try {

			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ProductoDuplicado productoDuplicado = new ProductoDuplicado();
			
			
			ProductoMapper mapper = session.getMapper(ProductoMapper.class);
			
			ProductoDuplicadoMapper mapperDup = session
					.getMapper(ProductoDuplicadoMapper.class);

			ProductoDuplicado prodDuplEncon = new ProductoDuplicado();
			prodDuplEncon=mapperDup
					.selectByProductoDuplicado(producto.getIdProducto());
			ProductoDuplicadoExample e= new ProductoDuplicadoExample();
			ProductoDuplicadoExample.Criteria p = e.createCriteria();
			int contar = mapperDup.countByExample(e);
			
			if (prodDuplEncon != null) {
				prodDuplEncon.setCantidad(
						prodDuplEncon.getCantidad() + 1);
				prodDuplEncon.setIdProducto(
						producto.getIdProducto());
				mapperDup.updateByPrimaryKeySelective(prodDuplEncon);
				session.commit();
			} else {
				productoDuplicado.setCantidad(0);
				productoDuplicado.setCantidad(productoDuplicado
						.getCantidad() + 1);
				productoDuplicado.setIdProducto(producto.getIdProducto());
				//productoDuplicado.setIdProductoDuplicado(contar+1);
				mapperDup.insert(productoDuplicado);
				session.commit();
			}
		} catch (SqlSessionException s) {
			s.printStackTrace();
		}
	}

	public Producto obtenerProducto(Integer idProducto) {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ProductoMapper mapper = session.getMapper(ProductoMapper.class);
			Producto p = mapper.selectByPrimaryKey(idProducto);
			return p;
		} catch (SqlSessionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void modificarProducto(Producto producto) {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ProductoMapper mapper = session.getMapper(ProductoMapper.class);
			mapper.updateByPrimaryKey(producto);
			session.commit();

		} catch (SqlSessionException s) {
			s.printStackTrace();
		}

	}

	public void eliminar(Integer idProducto) throws Exception {

		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ProductoMapper mapper = session.getMapper(ProductoMapper.class);
			mapper.deleteByPrimaryKey(idProducto);
			session.commit();

		} catch (SqlSessionException s) {
			s.printStackTrace();
		}
	}

}
