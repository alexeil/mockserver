package org.mockserver.client.serialization.model;

import org.junit.Test;
import org.mockserver.model.Body;
import org.mockserver.model.StringBody;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author jamesdbloom
 */
public class StringBodyDTOTest {

    @Test
    public void shouldReturnValueSetInConstructor() {
        // when
        StringBodyDTO stringBody = new StringBodyDTO(new StringBody("some_body", Body.Type.EXACT));

        // then
        assertThat(stringBody.getValue(), is("some_body"));
        assertThat(stringBody.getType(), is(Body.Type.EXACT));
    }

    @Test
    public void shouldBuildCorrectObject() {
        // when
        StringBody stringBody = new StringBodyDTO(new StringBody("some_body", Body.Type.XPATH)).buildObject();

        // then
        assertThat(stringBody.getValue(), is("some_body"));
        assertThat(stringBody.getType(), is(Body.Type.XPATH));
    }

    @Test
    public void coverage(){
        new StringBodyDTO();
    }
}
