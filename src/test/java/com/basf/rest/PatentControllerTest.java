package com.basf.rest;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PatentControllerTest {
    @Mock
    Logger log;
    @InjectMocks
    PatentController patentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenBasicGetRequest_whenIsExecuted_ThenReturnEmptyList() throws ClientProtocolException, IOException {
        // When
        HttpUriRequest request = new HttpGet( "http://localhost:8080/v1/patent/");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    //todo Delete

    //Todo UpdateFiles
}