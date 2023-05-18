const deleteButton = document.getElementById('delete-button');

if (deleteButton) {
  deleteButton.addEventListener('click', (event) => {
    event.preventDefault();
    if (confirm('削除してもよろしいですか？')) {
      const id = deleteButton.getAttribute('data-employee-id');
      fetch(`/employee/delete/${id}`, {
        method: 'DELETE',
      })
        .then((response) => {
          if (response.ok) {
            location.href = '/employee/list';
          } else {
            alert('削除に失敗しました。');
          }
        })
        .catch((error) => {
          console.error(error);
          alert('削除に失敗しました。');
        });
    }
  });
}