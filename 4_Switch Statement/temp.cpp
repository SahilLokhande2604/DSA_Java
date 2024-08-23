#include <iostream>
#include <vector>
#include <thread>
#include <functional>

// Function to perform matrix multiplication for a specific block
void multiplyBlock(const std::vector<std::vector<int>>& A,
                   const std::vector<std::vector<int>>& B,
                   std::vector<std::vector<int>>& result,
                   int row, int col, int colsA, int colsB) {
    for (int k = 0; k < colsA; ++k) {
        result[row][col] += A[row][k] * B[k][col];
    }
}

// Function to perform multi-threaded matrix multiplication
void multiplyMatrices(const std::vector<std::vector<int>>& A,
                      const std::vector<std::vector<int>>& B,
                      std::vector<std::vector<int>>& result) {
    int rowsA = A.size();
    int colsA = A[0].size();
    int colsB = B[0].size();

    std::vector<std::thread> threads;

    // Loop through each element of the result matrix and create a thread for each block
    for (int i = 0; i < rowsA; ++i) {
        for (int j = 0; j < colsB; ++j) {
            threads.emplace_back(std::thread(multiplyBlock, std::ref(A), std::ref(B), std::ref(result), i, j, colsA, colsB));
        }
    }

    // Wait for all threads to finish
    for (auto& thread : threads) {
        thread.join();
    }
}

int main() {
    // Initialize matrices A, B, and result
    std::vector<std::vector<int>> A = {{1, 2, 3},
                                      {4, 5, 6},
                                      {7, 8, 9}};

    std::vector<std::vector<int>> B = {{9, 8, 7},
                                      {6, 5, 4},
                                      {3, 2, 1}};

    std::vector<std::vector<int>> result(A.size(), std::vector<int>(B[0].size(), 0));

    // Call the multi-threaded matrix multiplication function
    multiplyMatrices(A, B, result);

    // Print or use the result matrix
    for (const auto& row : result) {
        for (int val : row) {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }

    return 0;
}
