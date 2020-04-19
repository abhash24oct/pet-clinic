package abhash.springframework.petclinic.services.map;

import abhash.springframework.petclinic.model.BaseEntity;
import abhash.springframework.petclinic.services.CrudService;

import java.util.*;

public abstract  class AbstractMapService<T extends BaseEntity,ID extends  Long>  {

    protected Map<Long,T> map = new HashMap<>();

    public Set<T> findAll(){
        System.out.println(map);
        return  new HashSet<>(map.values());
    }

    public T findById(ID id){
        return  map.get(id);
    }

    public T save (T object){

        if(object!=null){
            if(object.getId()==null){
                object.setId(getNextId());
                map.put(object.getId(),object);
            }
        }else{
            throw  new RuntimeException("Object cant be null");
        }
        return  object;
    }

    public void deleteById(ID id){
        map.remove(id);

    }

    public void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    public Long getNextId(){
        Long nextId=null;
        try {
            nextId=Collections.max(map.keySet())+1;
        }catch (NoSuchElementException e){
            nextId=1L;
        }
        return nextId;
    }
}
