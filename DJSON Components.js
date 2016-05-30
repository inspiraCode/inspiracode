// DJSON Main Structure
// Description: DJSON (Definition JSON) is the main file where is described a whole application.

{
    "projectName": "un proyecto",
    "description": "una description",
    "targetCompany": "foo",
    "deployments": [],
    "roles": [],
    "workflows": [],
    "documents": [],
    "entities": [],
    "templates": []
};



// Deployment Main Structure
// Description: Each application can have multiple deployments (Production, Development, etc.)
// TODO: Configuartion Management training
{
    "appName": '',
    "version": '',
    "database": '', //MySQL, SQL Server, PostrgreSQL, HBM, Oracle
    "middlewareTechnology": '', //Spring, EJB, Struts, .NET C#, .NET VB, PHP, NodeJS
    "frontendTechnology": '', //AngularJS, MithrilJS, EnyoJS,
    "settingsFile": '' //production, development, integration, sandbox, etc.
};


// Role:
// A simple array of strings


/*****************************************************************************************************************************/

// Workflow:
{
    "workflowName": '',
    "steps": []
};

// step:
{
    "stepName":'',
    "input": {
        "document": '',
        "status": '', //Status of which we receive the document, empty if new
        "roles": []
    },
    "process": {},
    "output": []
};

// process
"DATA_ENTRY": {
    "template": '',
};

"EMAIL": {
    "template": '',

};

"FILE_EXPORT": {
    "target": '',

};

"MACRO": {

};

"BATCH": {

};

"SCRIPT": {

};

"PUSH": {

};

"APPROVAL": {

};

"WORKFLOW": {

};

"SCHEDULE_TASK": {

};

// output
{
    "document": '',
    "status": '',
    "canRead": [], //'Allow All', 'Deny All'
    "canUpdate": [],
    "canDelete": []
};


/****************************************************************************************************************************/
// Document Main Structure:
{
    "name": '',
    "fields": {
        "requiredFields": {},
        "optionalFields": {},
        "complexFields": []
    },
    "relationships": {
        "oneToOne": [],
        "embedded": [],
        "oneToMany": [],
        "manyToMany": [],
        "manyToOne": [],
    }
};

// Entity Main Structure
{
    "name": '',
    "fields": {
        "requiredFields": {},
        "optionalFields": {},
        "complexFields": []
    },
    "relationships": {
        "oneToOne": [],
        "embedded": [],
        "oneToMany": [],
        "manyToMany": [],
        "manyToOne": [],
    }
};

// Catalog:
// A simple array of strings


// Complex Field
{
    "fieldName": '',
    "type": '',
    "required": true,
    "validations": []
};

// Validation
{
    "precision": 2,
    "rules": [],
    "minValue": 10,
    "maxValue": 50,
    "regex": '/someRegex/',
    "repeated": 2,
    "confirmed": false
};

// Rule
{
    "leftExpression": '',
    "operand": '', //EQUALS, GREATER THAN, LOWER THAN, GREATER OR EQUALS THAN, LOWER OR EQUALS THAN
    "rightExpression": ''
};

// Computed Value
{
    "fieldName": '',
    "formula": '[field1 + field2]',
    "function": someFunction(param1, param2) {}
};

// Relationship
// Each relation ship is an array of strings where each string is a reference to the foreign table
{
    "oneToOne": [], //option selected in dropdown cannot be selected again in any other form.
    "embedded": [],
    "oneToMany": [],

    // A catalog can be either a document, an entity or a simple catalog.
    "manyToMany": [], //multiple selection dropdown
    "manyToOne": [], //single selection dropdown, all dropdowns have an undefined value and are required by default
};



//TODO
//Filtros en cascada para dropdowns
//o niver pantalla

//Internacionalizacion
//Tipos de datos de campos
//


//Data types defaults:
//             Java        javascript          database            Allow Nulls     Default
// textarea:   String      string              varchar(1024)       true            null
// text:       String      string              varchar(250)        true            null
// number:     Integer     number              int                 true            null
// currency:   BigDecimal  number              decimal(20,6)       true            null
// float:      BigDecimal  number              decimal(20,6)       true            null
// email:      String      string              varchar(80)         true            null
// date:       Date        date                date                true            null
// datetime:   Date        date                datetime            true            null
// checkbox:   Boolean     boolean             bit                 true            null //Three states
// boolean:    bool        bool                bit                 false           false
// binary:     String      string              BLOB                true            null
// attachment: String      string              varchar(100)        true            null
// image:      String      string              varchar(100)        true            null


//GenPattern
{
    "fieldName": '',
    "type": 'generated',
    "genPattern": 'yymmdd000',
    "required": true,
    "validations": []
}

// //for dates:
// yyyy:   2016
// yy:       16

// mmm:     Jan
// mm:       01
// m:         1

// ddd:     Mon
// dd:       01
// d:         1

// w:         1 //Number of week in a year

// //sequences:
// 000:    000 //Three digits
// 001:    001 //Three digits starting at One
// A:        A //Literal
// \y\y:    yy //escaped yy
// \0:       0 //escaped zero
