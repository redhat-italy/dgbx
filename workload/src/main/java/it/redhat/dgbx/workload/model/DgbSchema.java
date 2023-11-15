package it.redhat.dgbx.workload.model;

import org.infinispan.protostream.GeneratedSchema;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(includeClasses = SftRec.class,
                        schemaPackageName = "it.redhat.dgbx.workload.model",
                        schemaFilePath = "proto",
                        schemaFileName = "dgb.proto")
public interface DgbSchema extends GeneratedSchema{
}
