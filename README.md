# DesignPatterns
Implementation of various design patterns
1. Singleton design pattern: implemented for both normal enviroment and multithreaded enviroment.
2. Prototyp design pattern
3. Builder design pattern


import React, { useState } from 'react';

// Define an interface for the selections state
interface Selections {
  param1: string;
  param2: string;
  param3: string;
  param4: string;
}

// Assuming a basic structure for the API response. Adjust this according to your actual data structure
interface ApiResponseItem {
  [key: string]: string | number; // This can be more specific based on your actual API response
}

const ComparisonTool: React.FC = () => {
  // State for storing dropdown selections
  const [selections, setSelections] = useState<Selections>({
    param1: '',
    param2: '',
    param3: '',
    param4: '',
  });

  // State for storing API response data
  const [results, setResults] = useState<ApiResponseItem[]>([]);

  // Handler for dropdown change
  const handleSelectChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    const { name, value } = e.target;
    setSelections((prevSelections) => ({
      ...prevSelections,
      [name]: value,
    }));
  };

  // Fetch results from API
  const fetchResults = async () => {
    try {
      const response = await fetch('/api/compare', {
        method: 'POST', // or 'GET', depending on your API setup
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(selections),
      });
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      setResults(data);
    } catch (error) {
      console.error('Failed to fetch data:', error);
    }
  };

  // Render component
  return (
    <div>
      <select name="param1" value={selections.param1} onChange={handleSelectChange}>
        {/* Options for dropdown 1 */}
        <option value="">Select Param1</option>
        {/* Add your options here */}
      </select>

      <select name="param2" value={selections.param2} onChange={handleSelectChange}>
        {/* Options for dropdown 2 */}
        <option value="">Select Param2</option>
        {/* Add your options here */}
      </select>

      <select name="param3" value={selections.param3} onChange={handleSelectChange}>
        {/* Options for dropdown 3 */}
        <option value="">Select Param3</option>
        {/* Add your options here */}
      </select>

      <select name="param4" value={selections.param4} onChange={handleSelectChange}>
        {/* Options for dropdown 4 */}
        <option value="">Select Param4</option>
        {/* Add your options here */}
      </select>

      <button onClick={fetchResults}>Compare</button>

      {results.length > 0 && (
        <table>
          <thead>
            <tr>
              {/* Assuming keys of result objects to create table headers */}
              {Object.keys(results[0]).map((key) => (
                <th key={key}>{key}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {results.map((result, index) => (
              <tr key={index}>
                {Object.entries(result).map(([key, value], idx) => (
                  <td key={idx}>{value}</td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default ComparisonTool;

