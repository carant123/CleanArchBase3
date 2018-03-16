package com.example.ccruzado.cleanarquitecturebase.model;

import com.example.ccruzado.cleanarquitecturebase.data.api.RequestResponse.model.response.TableElement;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by ccruzado on 14/03/2018.
 */
@Root(name = "string")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope")
})
public class NewDataSet {

    @ElementList(name = "NewDataSet",required = false)
    private List<Country> elements;




}
