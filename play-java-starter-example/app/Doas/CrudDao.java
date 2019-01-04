package Doas;

import java.util.Optional;
import java.util.Collection;

public interface CrudDao<E, K> {

    E create(E entity);
    Optional<E> read(K id);
    E update(E entity);
    E delete(K id);
    Collection<E> all();
}
