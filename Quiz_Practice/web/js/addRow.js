
var currentRow = 2;
function deleteRow(row) {
    var i = row.parentNode.parentNode.rowIndex;
    document.getElementById("myTable").deleteRow(i);
    var table = document.getElementById("myTable");
    var rows = table.getElementsByTagName("tr");
    for (var j = 1; j < rows.length; j++) {
        var questionCell = rows[j].getElementsByTagName("td")[0];
        var questionNumber = parseInt(questionCell.textContent);
        questionCell.textContent = questionNumber - 1;
    }

    updateQuestionColumn();
}
function updateQuestionColumn() {
    currentRow--;
    var questionCells = document.querySelectorAll('#myTable tbody tr td:first-child');
    questionCells.forEach(function (cell, index) {
        cell.textContent = index + 1;
    });
}
document.getElementById("addRow").addEventListener("click", function () {
    var table = document.getElementById("myTable").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(-1);
    var col1 = newRow.insertCell(0);
    var col2 = newRow.insertCell(1);
    var col3 = newRow.insertCell(2);
    var col4 = newRow.insertCell(3);
    var col5 = newRow.insertCell(4);
    var col6 = newRow.insertCell(5);
    var col7 = newRow.insertCell(6);
    var col8 = newRow.insertCell(7);
   // var col9 = newRow.insertCell(8);
    col1.innerHTML = currentRow;
    col2.innerHTML = '<textarea class="form-control" name="col1[' + currentRow + ']"style="height: 38px;" required></textarea>';
    col3.innerHTML = '<input class="form-control" type="text" name="col2[' + currentRow + ']" required />';
    col4.innerHTML = '<input class="form-control" type="text" name="col3[' + currentRow + ']" required />';
    col5.innerHTML = '<input class="form-control" type="text" name="col4[' + currentRow + ']" required/>';
    col6.innerHTML = '<input class="form-control" type="text" name="col5[' + currentRow + ']" required />';
    col7.innerHTML = '<select class="form-control" name="correctAnswer[' + currentRow + ']" style=" height: 38px;  margin-bottom: 30px; border: 1px solid #000;" > <option value="1">Answer 1</option> <option value="2">Answer 2</option><option value="3">Answer 3</option><option value="4">Answer 4</option> </select > ';
    col8.innerHTML = '<textarea class="form-control" name="explaination[' + currentRow + ']"style="height: 38px;" required></textarea>';
    //col9.innerHTML = '<td><input class="btn btn-danger" value="Delete" style="width: 100px;" onclick="deleteRow(this);" readonly></td>'
    document.getElementById('currentrow').value = currentRow;
    document.getElementById('numberquestion').value = currentRow;
    currentRow++;
});