document.addEventListener("DOMContentLoaded", function () {

    

});

function openModal(){
    document.querySelector(".modal").classList.toggle("open")
}

function deleteSelected() {

    const checked = document.querySelectorAll("input[name='defect_code_id']:checked");

    if (checked.length === 0) {
        alert("삭제할 항목을 선택하세요.");
        return;
    }
    
    const form = document.createElement("form");
    form.method = "post";
    form.action = "${pageContext.request.contextPath}/master-defect-delete";

    checked.forEach(c => {
        const input = document.createElement("input");
        input.type = "hidden";
        input.name = "defect_code_id";
        input.value = c.value;
        form.appendChild(input);
    });

    document.body.appendChild(form);
    form.submit();
}

function editDefect(id, code, name, type, remark) {
   
    document.getElementById("defect_code_id").value = id;
    document.getElementById("defect_code").value = code;
    document.getElementById("defect_name").value = name;
    document.getElementById("defect_type").value = type;
    document.getElementById("remark").value = remark;

    openModal();
}