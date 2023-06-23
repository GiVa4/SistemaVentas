<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
    <img src="${pageContext.request.contextPath}/img/icono.png" width="30" height="30" class="d-inline-block align-top" alt="">
    OnlineShop
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
          aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/home">Panel Principal</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/producto/list">Producto</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/empleado/list">Empleado</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/cliente/list">Clientes</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/venta/add?action=view_form">Nueva Venta</a>
      </li>
    </ul>
  </div>

  <div class="btn-group">
    <button type="button" class="btn btn-outline-light dropdown-toggle" data-toggle="dropdown"
            aria-expanded="false">
      ${empleado.getNombres()}
    </button>

    <div class="dropdown-menu dropdown-menu-right text-center">
      <a class="dropdown-item" href="#">
        <img src="${pageContext.request.contextPath}/img/user.png" style="height: 85%; width: 85%" alt=""/>
      </a>
      <a class="dropdown-item" href="#">${empleado.getNombres()}</a>
      <a class="dropdown-item" href="#">U18207722@utp.edu.pe</a>
      <div class="dropdown-divider"></div>
      <form action="${pageContext.request.contextPath}/logout">
        <button name="action" value="Salir" class="dropdown-item" href="#">Cerrar Sesi&oacute;n</button>
      </form>
    </div>
  </div>

</nav>