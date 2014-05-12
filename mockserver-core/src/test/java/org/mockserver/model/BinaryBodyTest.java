package org.mockserver.model;

import org.junit.Test;

import javax.xml.bind.DatatypeConverter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * @author jamesdbloom
 */
public class BinaryBodyTest {

    @Test
    public void shouldAlwaysCreateNewObject() {
        assertEquals(new BinaryBody(new byte[0]).binary(new byte[0]), BinaryBody.binary(new byte[0]));
        assertNotSame(BinaryBody.binary(new byte[0]), BinaryBody.binary(new byte[0]));
    }

    @Test
    public void shouldReturnValueSetInConstructor() {
        // given
        byte[] body = DatatypeConverter.parseBase64Binary("some_body");

        // when
        BinaryBody binaryBody = new BinaryBody(body);

        // then
        assertThat(binaryBody.getValue(), is(body));
        assertThat(binaryBody.getType(), is(Body.Type.BINARY));
    }
}
