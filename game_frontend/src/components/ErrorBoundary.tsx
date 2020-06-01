import React from 'react';

export default class ErrorBoundary extends React.Component<{fallback:JSX.Element}> {
    state = { hasError: false, error: null };
    static getDerivedStateFromError(error: Error) {
      return {
        hasError: true,
        error
      };
    }
    render() {
      if (this.state.hasError) {
        return this.props.fallback;
      }
      return this.props.children;
    }
  }