package it.redhat.dgbx.app.rest;

import io.quarkus.logging.Log;
import it.redhat.dgbx.app.model.Benchmark;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.concurrent.CompletableFuture;

@Path("/benchmark")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BenchmarkResource {
    private final static int BULK_SIZE = 100;

    @Channel("benchmarks")
    Emitter<Benchmark> benchmarkEmitter;

    @GET
    public String info() {
        return "CDLC - REST EndPoint to manage benchmark data in the cache"; 
    }

    @POST
    public String start(Benchmark data) {
        Log.info("[APP] submitting new Benchmark: " + data.getBenchmarkId());
        benchmarkEmitter.send(data);
        return data.getBenchmarkId();
    }

    private void loadEntries(Benchmark data){
        Log.info("starting new benchmark " + data.getDescription());
        /*
        String timeInHHMMSS = null;
        long globalEndTime = 0;
        long dailyStartTime = 0;
        long dailyEndTime = 0;
        long partialStartTime = 0;
        long partialEndTime = 0;
        int globalCounter = 0;
        int bulkCounter = 0;
        int counter = 0;
        long globalStartTime = System.currentTimeMillis();
        partialStartTime = globalStartTime;
        HashMap<String, SftRec> bulk = new HashMap<String, SftRec>();
        for(int i=0; i<data.getDays(); i++){
            dailyStartTime = System.currentTimeMillis();
            for(int j=0; j<data.getDailyEntries(); j++){
                String id = randomUUID().toString();
                SftRec recEntry = SftRecBuilder.build(data, i);
                bulk.put(id, recEntry);
                counter++;
                bulkCounter++;
                globalCounter++;
                if(bulkCounter == BULK_SIZE){
                    sftrec_cache.putAll(bulk);
                    bulkCounter = 0;
                    bulk.clear();
                }
                if(counter == 10000){
                    partialEndTime = System.currentTimeMillis();
                    Duration duration = Duration.ofMillis(partialEndTime - partialStartTime);
                    partialStartTime = partialEndTime;
                    long HH = duration.toHours();
                    long MM = duration.toMinutesPart();
                    long SS = duration.toSecondsPart();
                    timeInHHMMSS = String.format("%02d:%02d:%02d", HH, MM, SS);
                    counter = 0;
                    this.log(data.getSessionName(), "inserted " + globalCounter + " entries, partial time frame (10k): " + timeInHHMMSS);
                }
            }
            dailyEndTime = System.currentTimeMillis();
            Duration duration = Duration.ofMillis(dailyEndTime - dailyStartTime);
            dailyStartTime = dailyEndTime;
            long HH = duration.toHours();
            long MM = duration.toMinutesPart();
            long SS = duration.toSecondsPart();
            timeInHHMMSS = String.format("%02d:%02d:%02d", HH, MM, SS);
            this.log(data.getSessionName(), "==============================================================");
            this.log(data.getSessionName(), "completed day " + i + " time frame for this day: " + timeInHHMMSS);
            this.log(data.getSessionName(), "==============================================================");
        }
        globalEndTime = System.currentTimeMillis();
        Duration duration = Duration.ofMillis(globalEndTime - globalStartTime);
        long HH = duration.toHours();
        long MM = duration.toMinutesPart();
        long SS = duration.toSecondsPart();
        timeInHHMMSS = String.format("%02d:%02d:%02d", HH, MM, SS);
        this.log(data.getSessionName(), "==============================================================");
        this.log(data.getSessionName(), "inserted " + globalCounter + " entries, timeframe: " + timeInHHMMSS);
        this.log(data.getSessionName(), "==============================================================");

         */
    }

}
