package com.sac.pet.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sac.pet.model.Product;
import com.sac.pet.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product createProduct(Product product) {
        // Implementa la lógica para guardar el proveedor en la base de datos
        return productRepository.save(product);
    }
    
    @Override
    public boolean existProduct(Long product) {
    	boolean exist= false;
    	try {
    		 Optional<Product> productOpt = productRepository.findById(product);
    	     exist = productOpt.isPresent();
    	}catch(Exception e) {
    		System.out.println(e.toString());;
    	}
    	return exist;
    }
    
    @Override
    public String updateProduct(Long id, Product updatedProduct) {
    	String msg = "";
    	try {
    		if(existProduct(id)) {
    			Product existingProduct = productRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));
    			existingProduct.setNameProduct(updatedProduct.getNameProduct());
    			existingProduct.setCategory(updatedProduct.getCategory());
    			existingProduct.setPresentation(updatedProduct.getPresentation());
    			existingProduct.setParamSupplier(updatedProduct.getParamSupplier());
    			existingProduct.setProductWeight(updatedProduct.getProductWeight());
    			existingProduct.setProductWeightType(updatedProduct.getProductWeightType());
    			existingProduct.setPurchasePrice(updatedProduct.getPurchasePrice());
    			existingProduct.setSalePrice(updatedProduct.getSalePrice());
    			existingProduct.setRevenue(updatedProduct.getRevenue());
    			existingProduct.setStatus(updatedProduct.getStatus());
    			productRepository.save(existingProduct);
    			msg = "Se ha actualizado correctamente el Proveedor";
    		}else {
    			msg = "No se ha encontrado el Proveedor con el ID" + id;
    		}
    	}catch(Exception E){
			return E.toString();
    	}
		return msg;
    }
    @Override
    public Product findProductByName(String name) {
        return productRepository.findByDescription(name);
    }
    @Override
    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id)
                          .orElseThrow(() -> new NoSuchElementException("No existe el proveedor con ID: " + id));
        productRepository.delete(product);
    }
    
    public String changeProductStatus(Long id, Product product) {
        try {
            Optional<Product> optionalProduct = productRepository.findById(id);
            if (optionalProduct.isPresent()) {
                Product existingProduct = optionalProduct.get();
                existingProduct.setStatus(product.getStatus());
                productRepository.save(existingProduct);
                return "Se ha actualizado el estado del proveedor - ID: " + id;
            } else {
                return "No existe el proveedor que se quiere activar o inactivar - ID: " + id;
            }
        } catch (Exception e) {
            return e.toString();
        }
    }

}
