package de.oszimt.database.service;

public interface EditingDatabase<Type>  {

        public void insert(Type type);

        public void delete(Type type);

        public void update(Type type);

        public Type selectById(Type type);

        public Type selectAll(Type type);

}
