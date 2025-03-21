package br.com.springrest.springrest.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class ObjectMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListOBjects(List<O> origin, Class<D> destination){
        List<D> destinationObjetcts = new ArrayList<D>();
        for (Object o : origin){
            destinationObjetcts.add(mapper.map(o, destination));
        }
        return destinationObjetcts;
     
    }

}
