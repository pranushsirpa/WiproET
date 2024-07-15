def validate_policy_data(data):

    required_fields = ['policy_holder', 'premium']
    for field in required_fields:
        if field not in data or not data[field]:
            return False, f'Missing required field: {field}'
    
    if not isinstance(data['premium'], (int, float)):
        return False, 'Premium must be a number.'

    return True, None
