(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'vanilla'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'vanilla'.");
    }
    root.vanilla = factory(typeof vanilla === 'undefined' ? {} : vanilla, kotlin);
  }
}(this, function (_, Kotlin) {
  'use strict';
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  function Sample() {
  }
  Sample.prototype.checkMe = function () {
    return 12;
  };
  Sample.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Sample',
    interfaces: []
  };
  function Platform() {
    Platform_instance = this;
    this.name = 'JS';
  }
  Platform.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Platform',
    interfaces: []
  };
  var Platform_instance = null;
  function Platform_getInstance() {
    if (Platform_instance === null) {
      new Platform();
    }
    return Platform_instance;
  }
  function helloWorld(salutation) {
    var tmp$;
    var message = salutation + ' from Kotlin.JS, check me value: ' + (new Sample()).checkMe();
    (tmp$ = document.getElementById('js-response')) != null ? (tmp$.textContent = message) : null;
  }
  _.Sample = Sample;
  Object.defineProperty(_, 'Platform', {
    get: Platform_getInstance
  });
  _.helloWorld = helloWorld;
  Kotlin.defineModule('vanilla', _);
  return _;
}));

//# sourceMappingURL=vanilla.js.map
