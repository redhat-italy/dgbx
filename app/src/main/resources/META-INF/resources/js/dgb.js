var STORE_ORIGIN = window.location.origin;

function startBenchmark(benchmark, callbackFunction) {
    var theUrl = STORE_ORIGIN + '/benchmark';
    $.ajax({
        type: "POST",
        url: theUrl,
        data: JSON.stringify(benchmark),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        complete: function(response, status){
            var id = response.responseText;
            callbackFunction(id);
        }
    });
};

function showStartResult(benchmark_id) {
    $('#bench_id').html(benchmark_id);
    $('#alert_result').fadeIn(500);
    setTimeout(function () {
        $('#alert_result').fadeOut(500);
    }, 3000);
};
