(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'single_source_set'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'single_source_set'.");
    }
    root.single_source_set = factory(typeof single_source_set === 'undefined' ? {} : single_source_set, kotlin);
  }
}(this, function (_, Kotlin) {
  'use strict';
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_287e2$;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var exampleValue;
  function exampleFunction() {
    return ExampleObject_getInstance().exampleMethod();
  }
  function ExampleObject() {
    ExampleObject_instance = this;
    this.exampleProperty_0 = 'com.company.team.project.common.single_source_set.common';
  }
  ExampleObject.prototype.exampleMethod = function () {
    var output = ArrayList_init();
    output.add_11rb$(this.exampleProperty_0);
    return output;
  };
  ExampleObject.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'ExampleObject',
    interfaces: []
  };
  var ExampleObject_instance = null;
  function ExampleObject_getInstance() {
    if (ExampleObject_instance === null) {
      new ExampleObject();
    }
    return ExampleObject_instance;
  }
  var exampleValue_0;
  function exampleFunction_0() {
    return ExampleObject_getInstance_0().exampleMethod();
  }
  function ExampleObject_0() {
    ExampleObject_instance_0 = this;
    this.exampleProperty_0 = 'com.company.team.project.common.single_source_set.js.common';
  }
  ExampleObject_0.prototype.exampleMethod = function () {
    var output = ArrayList_init();
    output.addAll_brywnq$(exampleFunction());
    output.add_11rb$(this.exampleProperty_0);
    return output;
  };
  ExampleObject_0.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'ExampleObject',
    interfaces: []
  };
  var ExampleObject_instance_0 = null;
  function ExampleObject_getInstance_0() {
    if (ExampleObject_instance_0 === null) {
      new ExampleObject_0();
    }
    return ExampleObject_instance_0;
  }
  var package$com = _.com || (_.com = {});
  var package$company = package$com.company || (package$com.company = {});
  var package$team = package$company.team || (package$company.team = {});
  var package$project = package$team.project || (package$team.project = {});
  var package$common = package$project.common || (package$project.common = {});
  var package$single_source_set = package$common.single_source_set || (package$common.single_source_set = {});
  var package$common_0 = package$single_source_set.common || (package$single_source_set.common = {});
  Object.defineProperty(package$common_0, 'exampleValue', {
    get: function () {
      return exampleValue;
    }
  });
  package$common_0.exampleFunction = exampleFunction;
  Object.defineProperty(package$common_0, 'ExampleObject', {
    get: ExampleObject_getInstance
  });
  var package$js = package$single_source_set.js || (package$single_source_set.js = {});
  var package$common_1 = package$js.common || (package$js.common = {});
  Object.defineProperty(package$common_1, 'exampleValue', {
    get: function () {
      return exampleValue_0;
    }
  });
  package$common_1.exampleFunction = exampleFunction_0;
  Object.defineProperty(package$common_1, 'ExampleObject', {
    get: ExampleObject_getInstance_0
  });
  exampleValue = exampleFunction().toString();
  exampleValue_0 = exampleFunction_0().toString();
  Kotlin.defineModule('single_source_set', _);
  return _;
}));

//# sourceMappingURL=single_source_set.js.map
