### ALGS4 Exercise 2.1.14

1. I would compare both top cards and, if the top card were bigger than the second card, I would swap them.

2. I would mark the top card, so I could know it was the first card (in this iteration) sent to the bottom of the deck.

3. I would send the top card to the bottom of the deck.

4. I would repeat steps 1 and 3 until the marked card becomes the second card in the deck.

5. I would send the top card to the bottom of the deck (and the marked card is now at the top, signaling that a iteration is over).

6. If there were no swaps in this iteration, the deck is sorted. Otherwise, repeat steps 1 to 6.