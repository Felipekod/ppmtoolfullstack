import React, { Component } from 'react'
import ProjectItem from './Project/ProjectItem';

class Dashboard extends Component {
    render() {
        return (

            <div>
                <h1 className="alert alert-warning">
                     Welcome
                </h1>
                <ProjectItem></ProjectItem>
            </div>
            
        

        )
    }
}

export default Dashboard;
