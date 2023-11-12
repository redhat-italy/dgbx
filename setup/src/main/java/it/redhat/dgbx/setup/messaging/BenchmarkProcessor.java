package it.redhat.dgbx.setup.messaging;

import io.quarkus.logging.Log;
import io.smallrye.reactive.messaging.annotations.Blocking;
import it.redhat.dgbx.setup.model.Benchmark;
import it.redhat.dgbx.setup.model.Bulk;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.util.concurrent.CompletableFuture;

@ApplicationScoped
public class BenchmarkProcessor {

    @Incoming("benchmarks")
    @Outgoing("bulks")
    @Blocking
    public Bulk process(Benchmark data) throws InterruptedException {
        return new Bulk().setBenchmarkId(data.getReferral())
                .setDescription(data.getDescription())
                .setDay(data.getStartDate())
                .setDays(data.getDays())
                .setEntries(data.getEntries())
                .setDayOfSequence(0);
    }

}
