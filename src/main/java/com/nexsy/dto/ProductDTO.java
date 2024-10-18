package com.nexsy.dto;

import java.math.BigDecimal;


//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
	private Long pid;
	private String title;
	private BigDecimal priceFinal;
	private String description;
	private Long categoryId; // ID de la categoria
	private String imageUrl; // URL de la imagen
    private String name; //
//	private CategoryDTO category;
//	private List<String> images;

	public ProductDTO() {
	}

	 // Constructor adicional solo con los campos necesarios
    public ProductDTO(Long pid, String title, BigDecimal priceFinal, String description) {
        this.pid = pid;
        this.title = title;
        this.priceFinal = priceFinal; // Usar priceFinal
        this.description = description;
    }
    
    //crear producto
    public ProductDTO( Long id,String name, BigDecimal priceFinal, String description, Long categoryId, String imageUrl) {
        this.pid = id;
    	this.name = name;
        this.priceFinal = priceFinal;
        this.description = description;
        this.categoryId = categoryId;
        this.imageUrl = imageUrl;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPriceFinal() {
        return priceFinal;
    }

    public void setPriceFinal(BigDecimal priceFinal) {
        this.priceFinal = priceFinal;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public CategoryDTO getCategory() {
//		return category;
//	}
//
//	public void setCategory(CategoryDTO category) {
//		this.category = category;
//	}
//
//	public List<String> getImages() {
//		return images;
//	}
//
//	public void setImages(List<String> images) {
//		this.images = images;
//	}
//	
//	@Override
//	public String toString() {
//	    return "ProductDTO{" +
//	            "pid=" + pid +
//	            ", title='" + title + '\'' +
//	            ", priceFinal=" + priceFinal +
//	            ", description='" + description + '\'' +
//	            '}';
//	}


}
