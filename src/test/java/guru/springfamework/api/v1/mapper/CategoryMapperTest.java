package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.mapper.CategoryMapper;
import org.junit.Assert;
import org.junit.Test;

public class CategoryMapperTest {

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() throws Exception {
        Category category = new Category();
        String NAME = "Joe";
        category.setName(NAME);
        category.setId(1L);
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        Assert.assertEquals(Long.valueOf(1L), categoryDTO.getId());
        Assert.assertEquals(NAME, categoryDTO.getName());
    }
}
