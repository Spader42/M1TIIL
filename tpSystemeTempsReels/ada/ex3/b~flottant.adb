pragma Ada_95;
pragma Source_File_Name (ada_main, Spec_File_Name => "b~flottant.ads");
pragma Source_File_Name (ada_main, Body_File_Name => "b~flottant.adb");

with System.Restrictions;

package body ada_main is
   pragma Warnings (Off);

   procedure Do_Finalize;
   pragma Import (C, Do_Finalize, "system__standard_library__adafinal");

   Local_Priority_Specific_Dispatching : constant String := "";
   Local_Interrupt_States : constant String := "";

   procedure adainit is
      E012 : Boolean; pragma Import (Ada, E012, "system__soft_links_E");
      E118 : Boolean; pragma Import (Ada, E118, "system__fat_flt_E");
      E090 : Boolean; pragma Import (Ada, E090, "system__fat_llf_E");
      E022 : Boolean; pragma Import (Ada, E022, "system__exception_table_E");
      E071 : Boolean; pragma Import (Ada, E071, "ada__io_exceptions_E");
      E046 : Boolean; pragma Import (Ada, E046, "ada__tags_E");
      E055 : Boolean; pragma Import (Ada, E055, "ada__streams_E");
      E073 : Boolean; pragma Import (Ada, E073, "interfaces__c_E");
      E075 : Boolean; pragma Import (Ada, E075, "interfaces__c__strings_E");
      E016 : Boolean; pragma Import (Ada, E016, "system__secondary_stack_E");
      E064 : Boolean; pragma Import (Ada, E064, "system__finalization_root_E");
      E066 : Boolean; pragma Import (Ada, E066, "system__finalization_implementation_E");
      E062 : Boolean; pragma Import (Ada, E062, "ada__finalization_E");
      E083 : Boolean; pragma Import (Ada, E083, "ada__finalization__list_controller_E");
      E081 : Boolean; pragma Import (Ada, E081, "system__file_control_block_E");
      E060 : Boolean; pragma Import (Ada, E060, "system__file_io_E");
      E078 : Boolean; pragma Import (Ada, E078, "system__os_lib_E");
      E054 : Boolean; pragma Import (Ada, E054, "ada__text_io_E");
      E004 : Boolean; pragma Import (Ada, E004, "mes_io_E");

      Main_Priority : Integer;
      pragma Import (C, Main_Priority, "__gl_main_priority");
      Time_Slice_Value : Integer;
      pragma Import (C, Time_Slice_Value, "__gl_time_slice_val");
      WC_Encoding : Character;
      pragma Import (C, WC_Encoding, "__gl_wc_encoding");
      Locking_Policy : Character;
      pragma Import (C, Locking_Policy, "__gl_locking_policy");
      Queuing_Policy : Character;
      pragma Import (C, Queuing_Policy, "__gl_queuing_policy");
      Task_Dispatching_Policy : Character;
      pragma Import (C, Task_Dispatching_Policy, "__gl_task_dispatching_policy");
      Priority_Specific_Dispatching : System.Address;
      pragma Import (C, Priority_Specific_Dispatching, "__gl_priority_specific_dispatching");
      Num_Specific_Dispatching : Integer;
      pragma Import (C, Num_Specific_Dispatching, "__gl_num_specific_dispatching");
      Main_CPU : Integer;
      pragma Import (C, Main_CPU, "__gl_main_cpu");
      Interrupt_States : System.Address;
      pragma Import (C, Interrupt_States, "__gl_interrupt_states");
      Num_Interrupt_States : Integer;
      pragma Import (C, Num_Interrupt_States, "__gl_num_interrupt_states");
      Unreserve_All_Interrupts : Integer;
      pragma Import (C, Unreserve_All_Interrupts, "__gl_unreserve_all_interrupts");
      Zero_Cost_Exceptions : Integer;
      pragma Import (C, Zero_Cost_Exceptions, "__gl_zero_cost_exceptions");
      Detect_Blocking : Integer;
      pragma Import (C, Detect_Blocking, "__gl_detect_blocking");
      Default_Stack_Size : Integer;
      pragma Import (C, Default_Stack_Size, "__gl_default_stack_size");
      Leap_Seconds_Support : Integer;
      pragma Import (C, Leap_Seconds_Support, "__gl_leap_seconds_support");

      procedure Install_Handler;
      pragma Import (C, Install_Handler, "__gnat_install_handler");

      Handler_Installed : Integer;
      pragma Import (C, Handler_Installed, "__gnat_handler_installed");
   begin
      Main_Priority := -1;
      Time_Slice_Value := -1;
      WC_Encoding := 'b';
      Locking_Policy := ' ';
      Queuing_Policy := ' ';
      Task_Dispatching_Policy := ' ';
      System.Restrictions.Run_Time_Restrictions :=
        (Set =>
          (False, False, False, False, False, False, False, False, 
           False, False, False, False, False, False, False, False, 
           False, False, False, False, False, False, False, False, 
           False, False, False, False, False, False, False, False, 
           False, False, False, False, False, False, False, False, 
           False, False, False, False, False, False, False, False, 
           False, False, False, False, False, False, False, False, 
           False, False, False, False, False, False, False, False, 
           False, False, False, False, False, False, False, False, 
           False),
         Value => (0, 0, 0, 0, 0, 0, 0),
         Violated =>
          (False, False, True, True, False, False, False, False, 
           True, False, True, True, True, False, False, False, 
           False, False, True, True, False, True, True, True, 
           True, True, True, False, False, True, False, True, 
           False, False, False, False, False, True, False, False, 
           False, True, False, False, True, False, False, False, 
           False, False, False, False, False, True, True, True, 
           False, False, True, False, True, True, False, True, 
           True, False, False, False, False, False, False, False, 
           False),
         Count => (0, 0, 0, 0, 0, 0, 0),
         Unknown => (False, False, False, False, False, False, False));
      Priority_Specific_Dispatching :=
        Local_Priority_Specific_Dispatching'Address;
      Num_Specific_Dispatching := 0;
      Main_CPU := -1;
      Interrupt_States := Local_Interrupt_States'Address;
      Num_Interrupt_States := 0;
      Unreserve_All_Interrupts := 0;
      Zero_Cost_Exceptions := 1;
      Detect_Blocking := 0;
      Default_Stack_Size := -1;
      Leap_Seconds_Support := 0;

      if Handler_Installed = 0 then
         Install_Handler;
      end if;

      System.Fat_Flt'Elab_Spec;
      E118 := True;
      System.Fat_Llf'Elab_Spec;
      E090 := True;
      System.Exception_Table'Elab_Body;
      E022 := True;
      Ada.Io_Exceptions'Elab_Spec;
      E071 := True;
      Ada.Tags'Elab_Spec;
      Ada.Streams'Elab_Spec;
      E055 := True;
      Interfaces.C'Elab_Spec;
      Interfaces.C.Strings'Elab_Spec;
      E075 := True;
      E073 := True;
      Ada.Tags'Elab_Body;
      E046 := True;
      System.Soft_Links'Elab_Body;
      E012 := True;
      System.Secondary_Stack'Elab_Body;
      E016 := True;
      System.Finalization_Root'Elab_Spec;
      E064 := True;
      System.Finalization_Implementation'Elab_Spec;
      System.Finalization_Implementation'Elab_Body;
      E066 := True;
      Ada.Finalization'Elab_Spec;
      E062 := True;
      Ada.Finalization.List_Controller'Elab_Spec;
      E083 := True;
      System.File_Control_Block'Elab_Spec;
      E081 := True;
      System.Os_Lib'Elab_Body;
      E078 := True;
      System.File_Io'Elab_Body;
      E060 := True;
      Ada.Text_Io'Elab_Spec;
      Ada.Text_Io'Elab_Body;
      E054 := True;
      mes_io'elab_spec;
      E004 := True;
   end adainit;

   procedure adafinal is
   begin
      Do_Finalize;
   end adafinal;

   function main
     (argc : Integer;
      argv : System.Address;
      envp : System.Address)
      return Integer
   is
      procedure initialize (Addr : System.Address);
      pragma Import (C, initialize, "__gnat_initialize");

      procedure finalize;
      pragma Import (C, finalize, "__gnat_finalize");

      procedure Ada_Main_Program;
      pragma Import (Ada, Ada_Main_Program, "_ada_flottant");

      SEH : aliased array (1 .. 2) of Integer;

      Ensure_Reference : aliased System.Address := Ada_Main_Program_Name'Address;
      pragma Volatile (Ensure_Reference);

   begin
      gnat_argc := argc;
      gnat_argv := argv;
      gnat_envp := envp;

      Initialize (SEH'Address);
      adainit;
      Break_Start;
      Ada_Main_Program;
      Do_Finalize;
      Finalize;
      return (gnat_exit_status);
   end;

--  BEGIN Object file/option list
   --   ./mes_io.o
   --   ./flottant.o
   --   -L./
   --   -L/usr/lib/gcc/x86_64-linux-gnu/4.6/adalib/
   --   -shared
   --   -lgnat-4.6
--  END Object file/option list   

end ada_main;
