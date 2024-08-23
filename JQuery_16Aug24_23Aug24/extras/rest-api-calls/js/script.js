
$(() => {

    $("#content").html("<p><strong>Please wait while loading data...!</strong></p>");

    $.ajax({
        url: "https://jsonplaceholder.typicode.com/users",
        type: "GET"
    })
        .done(result => {
            var tab = $("<table></table>");

            var head = $("<tr></tr>");
            head.append("<th>User Id</th>");
            head.append("<th>Name</th>");
            head.append("<th>email</th>");

            tab.append(head);

            result.forEach(user => {
                var row = $("<tr></tr>");
                row.append("<td>"+user.id+"</td>");
                row.append("<td>"+user.name+"</td>");
                row.append("<td>"+user.email+"</td>");
                tab.append(row);
            });

            $("#content").html("");
            $("#content").append(tab);
        })
        .fail(err => {
            console.log(err);
            $("#content").html("<p><strong>Sorry! Failed to load data! Please retry later!</strong></p>");
        });
});