(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin', 'single_source_set'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'), require('single_source_set'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'vanilla'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'vanilla'.");
    }
    if (typeof single_source_set === 'undefined') {
      throw new Error("Error loading module 'vanilla'. Its dependency 'single_source_set' was not found. Please, check whether 'single_source_set' is loaded prior to 'vanilla'.");
    }
    root.vanilla = factory(typeof vanilla === 'undefined' ? {} : vanilla, kotlin, single_source_set);
  }
}(this, function (_, Kotlin, $module$single_source_set) {
  'use strict';
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_287e2$;
  var exampleFunction = $module$single_source_set.com.company.team.project.common.single_source_set.js.common.exampleFunction;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  function main() {
    updateTargetContent();
  }
  function updateTargetContent() {
    var tmp$;
    (tmp$ = document.getElementById('target')) != null ? (tmp$.textContent = exampleValue) : null;
  }
  var exampleValue;
  function exampleFunction_0() {
    return ExampleObject_getInstance().exampleMethod();
  }
  function ExampleObject() {
    ExampleObject_instance = this;
    this.exampleProperty_0 = 'com.company.team.project.application.js.vanilla';
  }
  ExampleObject.prototype.exampleMethod = function () {
    var output = ArrayList_init();
    output.addAll_brywnq$(exampleFunction());
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
  var package$com = _.com || (_.com = {});
  var package$company = package$com.company || (package$com.company = {});
  var package$team = package$company.team || (package$company.team = {});
  var package$project = package$team.project || (package$team.project = {});
  var package$application = package$project.application || (package$project.application = {});
  var package$js = package$application.js || (package$application.js = {});
  var package$vanilla = package$js.vanilla || (package$js.vanilla = {});
  package$vanilla.main = main;
  package$vanilla.updateTargetContent = updateTargetContent;
  Object.defineProperty(package$vanilla, 'exampleValue', {
    get: function () {
      return exampleValue;
    }
  });
  package$vanilla.exampleFunction = exampleFunction_0;
  Object.defineProperty(package$vanilla, 'ExampleObject', {
    get: ExampleObject_getInstance
  });
  exampleValue = exampleFunction_0().toString();
  main();
  Kotlin.defineModule('vanilla', _);
  return _;
}));

//# sourceMappingURL=vanilla.js.map
