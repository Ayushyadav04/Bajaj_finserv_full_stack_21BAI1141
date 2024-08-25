document.addEventListener('DOMContentLoaded', () => {
    const submitBtn = document.getElementById('submit-btn');
    const jsonInput = document.getElementById('json-input');
    const filterSelect = document.getElementById('filter-select');
    const responseText = document.getElementById('response-text');
    const clearFilterBtn = document.getElementById('clear-filter');
    const inputError = document.getElementById('input-error');

    let apiResponse = null; // To store the response from the API

    // Function to display filtered data
    function displayFilteredData(filter) {
        if (!apiResponse) {
            responseText.textContent = 'No data to display.';
            return;
        }

        if (filter === 'numbers') {
            if (apiResponse.numbers && apiResponse.numbers.length > 0) {
                responseText.textContent = `Numbers: ${apiResponse.numbers.join(', ')}`;
            } else {
                responseText.textContent = 'No numbers found in the data.';
            }
        } else if (filter === 'alphabets') {
            if (apiResponse.alphabets && apiResponse.alphabets.length > 0) {
                responseText.textContent = `Alphabets: ${apiResponse.alphabets.join(', ')}`;
            } else {
                responseText.textContent = 'No alphabets found in the data.';
            }
        } else {
            responseText.textContent = 'Invalid filter selected.';
        }
    }

    // Function to handle API response
    function handleApiResponse(data) {
        // Assuming the API response has the structure as provided
        apiResponse = data;

        // Enable the filter dropdown and clear button
        filterSelect.disabled = false;
        clearFilterBtn.disabled = false;

        // Reset filter selection
        filterSelect.value = '';
        responseText.textContent = 'Select a filter to view data.';
    }

    // Event listener for Submit button
    submitBtn.addEventListener('click', () => {
        const userInput = jsonInput.value.trim();

        // Clear previous error message
        inputError.textContent = '';

        if (!userInput) {
            inputError.textContent = 'Please enter JSON data before submitting.';
            return;
        }

        let parsedInput;
        try {
            parsedInput = JSON.parse(userInput);
        } catch (error) {
            inputError.textContent = 'Invalid JSON format. Please correct it.';
            return;
        }

        // Prepare the POST request to the API
        fetch('http://localhost:8080/api/process', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(parsedInput)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`API request failed with status ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            handleApiResponse(data);
        })
        .catch(error => {
            inputError.textContent = `Error: ${error.message}`;
            responseText.textContent = 'Failed to retrieve data from the API.';
            filterSelect.disabled = true;
            clearFilterBtn.disabled = true;
        });
    });

    // Event listener for filter selection
    filterSelect.addEventListener('change', (event) => {
        const selectedFilter = event.target.value;
        displayFilteredData(selectedFilter);
    });

    // Event listener for Clear Filter button
    clearFilterBtn.addEventListener('click', () => {
        filterSelect.value = '';
        responseText.textContent = 'Filter cleared. Select a filter to view data.';
    });
});
