package com.sd.oc.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return localDate.toString();
    }

    @Override
    public LocalDate unmarshal(String localDateString) throws Exception {
        return LocalDate.parse(localDateString);
    }
}
