import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
  scenarios: {
    allProducts: {
      executor: 'constant-vus',
      vus: 100,
      duration: '10s',
      exec: "allProducts",
      gracefulStop: '0s',
    },
    singleProduct: {
      executor: 'constant-vus',
      vus: 100,
      duration: '10s',
      exec: "singleProduct",
      gracefulStop: '0s',
      startTime: '10s'
    },
    normal: {
      executor: 'constant-vus',
      vus: 100,
      duration: '10s',
      exec: "normal",
      gracefulStop: '0s',
      startTime: '20s'
    },
    notFound: {
      executor: 'constant-vus',
      vus: 100,
      duration: '10s',
      exec: "notFound",
      gracefulStop: '0s',
      startTime: '30s'
    },
    error: {
      executor: 'constant-vus',
      vus: 100,
      duration: '10s',
      exec: "error",
      gracefulStop: '0s',
      startTime: '40s'
    }
  }
};

const host = "http://host.docker.internal:5000";

export function allProducts() {
  let res = http.get(host + "/product/");
  check(res, {
    "status is 200": (r) => r.status === 200,
    "response is JSON": (r) => r.headers['Content-Type'] === "application/json"
  });
  sleep(0.5);
}

export function singleProduct() {
  let res = http.get(host + "/product/1");
  check(res, {
    "status is 200": (r) => r.status === 200,
    "response contains marca": (r) => JSON.parse(r.body).marca !== undefined
  });
  sleep(0.5);
}

export function normal() {
  let res = http.get(host + "/product/1/similar");
  check(res, {
    "status is 200": (r) => r.status === 200,
    "response is JSON": (r) => r.headers['Content-Type'] === "application/json"
  });
  sleep(0.5);
}

export function notFound() {
  let res = http.get(host + "/product/999");
  check(res, {
    "status is 404": (r) => r.status === 404
  });
  sleep(0.5);
}

export function error() {
  let res = http.get(host + "/product/5/similar");
  check(res, {
    "status is 500": (r) => r.status === 500
  });
  sleep(0.5);
}