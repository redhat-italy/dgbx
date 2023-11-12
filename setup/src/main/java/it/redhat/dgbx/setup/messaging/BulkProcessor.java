package it.redhat.dgbx.setup.messaging;

import io.smallrye.reactive.messaging.annotations.Blocking;
import it.redhat.dgbx.setup.model.Benchmark;
import it.redhat.dgbx.setup.model.Bulk;
import it.redhat.dgbx.setup.model.Workload;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class BulkProcessor {
    @Incoming("bulks_read")
    @Outgoing("workloads")
    @Blocking
    public Workload process(Bulk data) throws InterruptedException {
        long day = (data.getDay() + ((1000 * 60 * 60 * 24) * data.getDayOfSequence()));
        return new Workload().setBenchmarkId(data.getBenchmarkId())
                    .setDay(day)
                    .setEntries(data.getEntries());
    }
}
