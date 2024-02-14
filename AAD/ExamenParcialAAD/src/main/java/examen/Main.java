package examen;

import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {
	//Darío
	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());
		
		Session session = context.currentSession();
		int respuesta = 0;
		Scanner sca = new Scanner(System.in);
		while(true) {
			System.out.println("-----------------MENÚ---------------"
					+ "\n\t\u001B[31m 1. Gestionar pacientes"
					+ "\n\t\u001B[32m 2. Gestionar médicos"
					+ "\n\t\u001B[33m 3. Gestionar citas."
					+ "\n\t\u001B[34m 4. Salir \u001B[30m");
			
			try {
				respuesta = Integer.parseInt(sca.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Ha habido un error al leer el número");
				continue;
			}
			
			switch(respuesta) {
				case 1:
					menuPacientes(session, sca);
					break;
				case 2:
					menuMedico(session, sca);
					break;
				case 3:
					menuCita(session, sca);
					break;
				case 4:
					System.exit(0);
				default:
					System.out.println("Eso no es una opción");
					break;
			
			}
			
		}
		
	}
	
	
	private static void menuPacientes(Session session, Scanner sca) {

		int respuesta = 0;
		PacienteDAOHibernate dao = new PacienteDAOHibernate(session);
		while (true) {
			System.out.println("\n\t\u001B[31m-----PACIENTES--------\u001B[30m" + "\n\t1. Insertar paciente"
					+ "\n\t2. Actualizar paciente" + "\n\t3. Mostrar lista de pacientes" + "\n\t4. Eliminar paciente"
					+ "\n\t5. Volver");
			try {
				respuesta = Integer.parseInt(sca.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ha habido un error al leer el número");
				continue;
			}

			switch (respuesta) {

			case 1:
				Paciente paciente = new Paciente();

				while (true) {
					try {
						System.out.println("Dime su id, ha de ser un número entero");
						paciente.setId(Integer.parseInt(sca.nextLine()));
						break;
					} catch (NumberFormatException e) {
						System.out.println("Creo que no has puesto un número ahí...");
					}
				}
				System.out.println("Dime su nombre");
				paciente.setNombre(sca.nextLine());
				System.out.println("Dime sus apellidos");
				paciente.setApellidos(sca.nextLine());
				System.out.println("Dime su ciudad");
				paciente.setCiudad(sca.nextLine());
				System.out.println("Dime su dirección");
				paciente.setDireccion(sca.nextLine());
				System.out.println("Dime su teléfono");
				paciente.setTelefono(sca.nextLine());
				while (true) {
					try {
						System.out.println("Dime su edad");
						paciente.setEdad(Integer.parseInt(sca.nextLine()));
						break;
					} catch (NumberFormatException e) {
						System.out.println("Error al leer la edad");
					}
				}
				System.out.println("Dime su historial......???????????????????????????????");
				paciente.setHistorial(sca.nextLine());

				dao.agregarPaciente(paciente);

				break;

			case 2:
				Paciente pacienteUpdate = new Paciente();
				while (true) {
					try {
						System.out.println("Dime su id, ha de ser un número entero");
						pacienteUpdate.setId(Integer.parseInt(sca.nextLine()));
						break;
					} catch (NumberFormatException e) {
						System.out.println("Creo que no has puesto un número ahí...");
					}
				}
				System.out.println("Dime su nombre");
				pacienteUpdate.setNombre(sca.nextLine());
				System.out.println("Dime sus apellidos");
				pacienteUpdate.setApellidos(sca.nextLine());
				System.out.println("Dime su ciudad");
				pacienteUpdate.setCiudad(sca.nextLine());
				System.out.println("Dime su dirección");
				pacienteUpdate.setDireccion(sca.nextLine());
				System.out.println("Dime su teléfono");
				pacienteUpdate.setTelefono(sca.nextLine());
				while (true) {
					try {
						System.out.println("Dime su edad");
						pacienteUpdate.setEdad(Integer.parseInt(sca.nextLine()));
						break;
					} catch (NumberFormatException e) {
						System.out.println("Error al leer la edad");
					}
				}
				System.out.println("Dime su historial......???????????????????????????????");
				pacienteUpdate.setHistorial(sca.nextLine());

				dao.actualizarPaciente(pacienteUpdate);

				break;

			case 3:
				System.out.println(dao.mostrarPacientes());
				break;

			case 4:
				System.out.println("Dime la id del paciente a eliminar");
				try {
					dao.eliminarPaciente(Integer.parseInt(sca.nextLine()));
				} catch (NumberFormatException e) {
					System.out.println("Creo que no has puesto un número ahí...");
				}

				break;
			case 5:
				return;

			}
		}
	}
	
	
	public static void menuMedico(Session session, Scanner sca) {

		int respuesta = 0;
		MedicoDAOHibernate dao = new MedicoDAOHibernate(session);
		while (true) {
			System.out.println("\n\t\u001B[32m-----MÉDICOS--------\u001B[30m" + "\n\t1. Insertar médico"
					+ "\n\t2. Actualizar médico" + "\n\t3. Mostrar lista de médicos" + "\n\t4. Eliminar médico"
					+ "\n\t5. Volver");
			try {
				respuesta = Integer.parseInt(sca.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ha habido un error al leer el número");
				continue;
			}

			switch (respuesta) {

			case 1:
				Medico medico = new Medico();

				while (true) {
					try {
						System.out.println("Dime su id, ha de ser un número entero");
						medico.setId(Integer.parseInt(sca.nextLine()));
						break;
					} catch (NumberFormatException e) {
						System.out.println("Creo que no has puesto un número ahí...");
					}
				}
				System.out.println("Dime su nombre");
				medico.setNombre(sca.nextLine());
				System.out.println("Dime sus apellidos");
				medico.setApellidos(sca.nextLine());
				System.out.println("Dime su especialiad");
				medico.setEspecialidad(sca.nextLine());

				dao.agregarMedico(medico);

				break;

			case 2:
				Medico medicoUpdate = new Medico();

				while (true) {
					try {
						System.out.println("Dime su id, ha de ser un número entero");
						medicoUpdate.setId(Integer.parseInt(sca.nextLine()));
						break;
					} catch (NumberFormatException e) {
						System.out.println("Creo que no has puesto un número ahí...");
					}
				}
				System.out.println("Dime su nombre");
				medicoUpdate.setNombre(sca.nextLine());
				System.out.println("Dime sus apellidos");
				medicoUpdate.setApellidos(sca.nextLine());
				System.out.println("Dime su especialiad");
				medicoUpdate.setEspecialidad(sca.nextLine());

				dao.actualizarMedico(medicoUpdate);

				break;

			case 3:
				System.out.println(dao.mostrarMedicos());
				break;

			case 4:
				System.out.println("Dime la id del médico a eliminar");
				try {
					dao.eliminarMedico(Integer.parseInt(sca.nextLine()));
				} catch (NumberFormatException e) {
					System.out.println("Creo que no has puesto un número ahí...");
				}

				break;
			case 5:
				return;

			}
		}
	}
	
	public static void menuCita(Session session, Scanner sca) {

		int respuesta = 0;
		CitaDAOHibernate dao = new CitaDAOHibernate(session);
		while (true) {
			System.out.println("\n\t\u001B[33m-----CITAS--------\u001B[30m" + "\n\t1. Insertar cita"
					+ "\n\t2. Actualizar cita" + "\n\t3. Mostrar lista de citas" + "\n\t4. Eliminar cita"
					+ "\n\t5. Volver");
			try {
				respuesta = Integer.parseInt(sca.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ha habido un error al leer el número");
				continue;
			}

			switch (respuesta) {

			case 1:
				Cita cita = new Cita();

				while (true) {
					try {
						System.out.println("Dime la id de la cita");
						cita.setId(Integer.parseInt(sca.nextLine()));
						break;
					} catch (NumberFormatException e) {
						System.out.println("Creo que no has puesto un número ahí...");
					}
				}
				while (true) {
					try {
						System.out.println("Dime la id del paciente");
						cita.setId_paciente(Integer.parseInt(sca.nextLine()));
						break;
					} catch (NumberFormatException e) {
						System.out.println("Creo que no has puesto un número ahí...");
					}
				}
				while (true) {
					try {
						System.out.println("Dime la id del médico");
						cita.setId_medico(Integer.parseInt(sca.nextLine()));
						break;
					} catch (NumberFormatException e) {
						System.out.println("Creo que no has puesto un número ahí...");
					}
				}
				while(true) {
					try {
						System.out.println("Dime el año de la fecha");
						int year = Integer.parseInt(sca.nextLine());
						year = year - 1900;
						System.out.println("Dime el mes");
						int mes = Integer.parseInt(sca.nextLine());
						System.out.println("Dime el día");
						int dia = Integer.parseInt(sca.nextLine());
						Date fecha = new Date(year, mes, dia);
						cita.setFecha(fecha);
						break;
					} catch (NumberFormatException e) {
						System.out.println("Creo que no has puesto un número ahí...");
					}
				}
				System.out.println("Dime la hora de la cita");
				cita.setHora(sca.nextLine());
				dao.agregarCita(cita);

				break;

			case 2:
				Cita citaUpdate = new Cita();

				while (true) {
					try {
						System.out.println("Dime la id de la cita");
						citaUpdate.setId(Integer.parseInt(sca.nextLine()));
						break;
					} catch (NumberFormatException e) {
						System.out.println("Creo que no has puesto un número ahí...");
					}
				}
				while (true) {
					try {
						System.out.println("Dime la id del paciente");
						citaUpdate.setId_paciente(Integer.parseInt(sca.nextLine()));
						break;
					} catch (NumberFormatException e) {
						System.out.println("Creo que no has puesto un número ahí...");
					}
				}
				while (true) {
					try {
						System.out.println("Dime la id del médico");
						citaUpdate.setId_medico(Integer.parseInt(sca.nextLine()));
						break;
					} catch (NumberFormatException e) {
						System.out.println("Creo que no has puesto un número ahí...");
					}
				}
				while(true) {
					try {
						System.out.println("Dime el año de la fecha");
						int year = Integer.parseInt(sca.nextLine());
						year = year - 1900;
						System.out.println("Dime el mes");
						int mes = Integer.parseInt(sca.nextLine());
						System.out.println("Dime el día");
						int dia = Integer.parseInt(sca.nextLine());
						Date fecha = new Date(year, mes, dia);
						citaUpdate.setFecha(fecha);
						break;
					} catch (NumberFormatException e) {
						System.out.println("Creo que no has puesto un número ahí...");
					}
				}
				System.out.println("Dime la hora de la cita");
				citaUpdate.setHora(sca.nextLine());
				dao.agregarCita(citaUpdate);

				break;

			case 3:
				System.out.println(dao.mostrarCitas());
				break;

			case 4:
				System.out.println("Dime la id de la cita a eliminar");
				try {
					dao.eliminarCita(Integer.parseInt(sca.nextLine()));
				} catch (NumberFormatException e) {
					System.out.println("Creo que no has puesto un número ahí...");
				}
				
				break;
			case 5:
				return;

			}
		}
	}
	
}
