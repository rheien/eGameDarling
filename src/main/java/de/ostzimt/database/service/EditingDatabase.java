package de.ostzimt.database.service;

import de.ostzimt.database.model.versand.Kunden;

public interface EditingDatabase<Type>  {

        public void insert(Type type);

        public void delete(Type type);

        public void update(Type type);

        public Type selectById(Type type);

        public Type selectAll(Type type);

}
