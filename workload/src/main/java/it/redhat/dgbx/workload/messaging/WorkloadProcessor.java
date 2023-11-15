package it.redhat.dgbx.workload.messaging;

import io.quarkus.infinispan.client.Remote;
import io.quarkus.logging.Log;
import io.smallrye.reactive.messaging.annotations.Blocking;
import it.redhat.dgbx.workload.model.Queries;
import it.redhat.dgbx.workload.model.SftRec;
import it.redhat.dgbx.workload.model.SftRecBuilder;
import it.redhat.dgbx.workload.model.Workload;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.infinispan.client.hotrod.RemoteCache;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import static java.util.UUID.randomUUID;

@ApplicationScoped
public class WorkloadProcessor {
    private final static int BULK_SIZE = 100;
    @Inject
    @Remote("sftrec")
    RemoteCache<String, SftRec> sftrec_cache;

    @Channel("queries")
    Emitter<Queries> queriesEmitter;

    @Incoming("workloads")
    @Blocking
    public void process(Workload data) throws InterruptedException {
        CompletableFuture.runAsync(() -> loadEntries(data.getDay(), data.getEntries()));
    }

    private void loadEntries(long day, int size){
        HashMap<String, SftRec> bulk = new HashMap<String, SftRec>();
        int bulkCounter = 0;
        int counter = 0;
        int globalCounter = 0;
        for(int j=0; j<size; j++){
            globalCounter++;
            String id = randomUUID().toString();
            SftRec recEntry = SftRecBuilder.build(day, size);
            bulk.put(id, recEntry);
            if(bulkCounter++ == BULK_SIZE){
                sftrec_cache.putAll(bulk);
                bulkCounter = 0;
                bulk.clear();
            }
            if(counter++ == 10000){
                counter = 0;
                Log.info("[Workload] inserted " + globalCounter + " entries of " + size);
            }
        }
        queriesEmitter.send(new Queries().setSize(size));
    }
}