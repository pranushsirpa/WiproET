import requests

def get_request_example():
    url = 'https://jsonplaceholder.typicode.com/posts/1'

    try:
        response = requests.get(url)
        response.raise_for_status()

        print("Response JSON:")
        print(response.json())

    except requests.exceptions.HTTPError as http_err:
        print(f"HTTP error occurred: {http_err}")
    except Exception as err:
        print(f"Other error occurred: {err}")

get_request_example()