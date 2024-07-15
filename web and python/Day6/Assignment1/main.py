import datetime
from dao import create_policy, create_claim, update_policy, update_claim, delete_policy, delete_claim
from queries import get_total_premium_amount, get_average_claim_amount, get_policy_with_most_claims

if __name__ == "__main__":
   
    policy1 = create_policy("P001", "John Doe", 1000.00)
    policy2 = create_policy("P002", "Jane Smith", 1500.00)

    claim1 = create_claim(policy1.id, "C001", datetime.datetime(2024, 7, 15), 500.00)
    claim2 = create_claim(policy1.id, "C002", datetime.datetime(2024, 7, 20), 700.00)
    claim3 = create_claim(policy2.id, "C003", datetime.datetime(2024, 7, 25), 600.00)

   
    updated_policy = update_policy(policy1.id, new_holder_name="John Updated Doe")

   
    total_premium = get_total_premium_amount()
    print(f"Total premium amount: ${total_premium}")

    avg_claim_amount = get_average_claim_amount()
    print(f"Average claim amount: ${avg_claim_amount}")

    policies_with_most_claims = get_policy_with_most_claims()
    print("Policies with most claims:")
    for policy, count in policies_with_most_claims:
        print(f"Policy {policy.policy_number} - {policy.holder_name}: {count} claims")

   
    delete_claim(claim1.id)
    delete_claim(claim2.id)
    delete_claim(claim3.id)
    delete_policy(policy1.id)
    delete_policy(policy2.id)
