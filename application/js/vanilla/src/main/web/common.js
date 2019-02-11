if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'common'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'common'.");
}
var common = function (_, Kotlin) {
  'use strict';
  function common() {
    return 'common';
  }
  function commonJs() {
    return common() + '|commonJs';
  }
  var package$com = _.com || (_.com = {});
  var package$company = package$com.company || (package$com.company = {});
  var package$team = package$company.team || (package$company.team = {});
  var package$project = package$team.project || (package$team.project = {});
  var package$common = package$project.common || (package$project.common = {});
  var package$common_0 = package$common.common || (package$common.common = {});
  package$common_0.common = common;
  var package$js = package$common.js || (package$common.js = {});
  var package$common_1 = package$js.common || (package$js.common = {});
  package$common_1.commonJs = commonJs;
  Kotlin.defineModule('common', _);
  return _;
}(typeof common === 'undefined' ? {} : common, kotlin);
