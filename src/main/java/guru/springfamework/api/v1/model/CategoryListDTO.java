package guru.springfamework.api.v1.model;

import java.util.List;

/**
 * Created by jt on 9/26/17.
 */
public class CategoryListDTO {

    List<CategoryDTO> categories;

    public CategoryListDTO(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public List<CategoryDTO> getCategories() {
        return this.categories;
    }

}