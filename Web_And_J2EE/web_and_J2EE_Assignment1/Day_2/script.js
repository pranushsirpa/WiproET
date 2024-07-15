document.addEventListener('DOMContentLoaded', function() {
    // Example policy data
    let policies = [
        { id: 1, name: "Health Insurance", holder: "John Doe", premium: 300 },
        { id: 2, name: "Car Insurance", holder: "Jane Smith", premium: 200 },
        { id: 3, name: "Home Insurance", holder: "Jim Brown", premium: 400 }
    ];

    // Function to populate the table with policies
    function populateTable() {
        const tbody = document.querySelector('tbody');
        tbody.innerHTML = ''; // Clear existing rows
        policies.forEach(policy => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <th scope="row">${policy.id}</th>
                <td>${policy.name}</td>
                <td>${policy.holder}</td>
                <td>${policy.premium}</td>
                <td><button class="btn btn-primary btn-sm view-details" data-id="${policy.id}">View</button></td>
            `;
            tbody.appendChild(row);
        });

        // Add event listeners to view buttons
        document.querySelectorAll('.view-details').forEach(button => {
            button.addEventListener('click', function() {
                const policyId = this.getAttribute('data-id');
                const policy = policies.find(p => p.id == policyId);
                alert(`Policy Details:\n\nName: ${policy.name}\nHolder: ${policy.holder}\nPremium: ${policy.premium}`);
            });
        });
    }

    // Initial table population
    populateTable();

    // Sorting function
    function sortPolicies(criteria) {
        policies.sort((a, b) => {
            if (a[criteria] < b[criteria]) return -1;
            if (a[criteria] > b[criteria]) return 1;
            return 0;
        });
        populateTable();
    }

    // Add event listeners to sort buttons
    document.querySelectorAll('.sort-btn').forEach(button => {
        button.addEventListener('click', function() {
            const sortCriteria = this.getAttribute('data-sort');
            sortPolicies(sortCriteria);
        });
    });
});
