/* Emergencies trigger */
/* Asigna la fecha actual a la nueva emergencia ingresada. */
CREATE OR REPLACE FUNCTION emergency_start_date() RETURNS TRIGGER AS
$BODY$
BEGIN
    NEW.start_date = CURRENT_DATE;
    RETURN NEW;
END;
$BODY$ LANGUAGE plpgsql;

CREATE TRIGGER emergency_date_trigger
BEFORE INSERT ON emergencies
FOR EACH ROW
EXECUTE PROCEDURE emergency_start_date();



/* Tasks trigger */
/* Suma 1 a la cantidad de voluntarios participantes en la tarea específica. */
CREATE OR REPLACE FUNCTION add_enrolled_volunteer() RETURNS TRIGGER AS
$BODY$
BEGIN
    IF NEW.flag_participated = true THEN
        UPDATE tasks SET enrolled_volunteers = enrolled_volunteers + 1
        WHERE id = NEW.id_task;
    END IF;
    RETURN NEW;
END;
$BODY$ LANGUAGE plpgsql;

CREATE TRIGGER new_enrolled_volunteer
AFTER INSERT ON rankings
FOR EACH ROW
EXECUTE PROCEDURE add_enrolled_volunteer();