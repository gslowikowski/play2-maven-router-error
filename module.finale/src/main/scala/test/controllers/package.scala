package example.test

/*
 * We need to alias play Assets controller since there is also a relative package named controller in lifecycle.frontend.server.
 * Note that we can't use _root_ in play route files.
 */
package object test {
  type Assets = _root_.controllers.Assets
}

