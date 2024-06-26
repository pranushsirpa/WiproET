import requests
import json

def post_request_example():
    url = 'https://jsonplaceholder.typicode.com/posts'
    data = {
        'title': 'foo',
        'body': 'bar',
        'userId': 1
    }

    try:
        json_data = json.dumps(data)
        headers = {'Content-type': 'application/json'}
        response = requests.post(url, data=json_data, headers=headers)
        response.raise_for_status()
        print("Response JSON:")
        print(response.json())

    except requests.exceptions.HTTPError as http_err:
        print(f"HTTP error occurred: {http_err}")
    except Exception as err:
        print(f"Other error occurred: {err}")

post_request_example()