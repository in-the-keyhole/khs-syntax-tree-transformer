package khs.res.db2demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import khs.cobol.transformer.runtime.Display;
import khs.cobol.transformer.runtime.Database;
import khs.cobol.transformer.runtime.InItem;
import khs.cobol.transformer.runtime.OutItem;

/**
 * Java source, file WBSRS009.java generated from Cobol source, WBSRS009.cbl
 *
 * @version 0.0.2
 * @author Keyhole Software LLC
 */
public class WBSRS009   {
    private static Logger Log = LoggerFactory.getLogger("WBSRS009");

 	
 	// Level 01
	private String ws_pgm_id;

 	// Level 05
	private String db2error_buffersize;

	// Level 05
	private String db2error_buffer;

	// Level 01
	private InItem[] db2error = new InItem[]{ () -> db2error_buffersize, () -> db2error_buffer };
 	// Level 77
	private String db2error_linewidth;

 	// Level 77
	private String sqlstate_class_success;

 	// Level 77
	private String sqlstate_class_warning;

 	// Level 77
	private String sqlstate_class_no_data;

 	// Level 77
	private String sqlstate_class_connect_except;

 	// Level 77
	private String sqlstate_class_cardinality;

 	// Level 77
	private String sqlstate_class_data_except;

 	// Level 77
	private String sqlstate_class_constraint;

 	// Level 77
	private String sqlstate_class_inv_curs_state;

 	// Level 77
	private String sqlstate_class_inv_stmt_id;

 	// Level 77
	private String sqlstate_class_syntax;

 	// Level 77
	private String sqlstate_class_serialization;

 	// Level 77
	private String sqlstate_class_authorzation;

 	// Level 77
	private String sqlstate_class_inv_app_state;

 	// Level 77
	private String sqlstate_class_dup_undef_name;

 	// Level 77
	private String sqlstate_class_inv_operand;

 	// Level 77
	private String sqlstate_class_limit;

 	// Level 77
	private String sqlstate_class_prereq_state;

 	// Level 77
	private String sqlstate_class_misc_restrict;

 	// Level 77
	private String sqlstate_class_resource;

 	// Level 77
	private String sqlstate_class_system_error;

 	// Level 77
	private String sql_exec_ok;

 	// Level 77
	private String sql_warn_disconnect_err;

 	// Level 77
	private String sql_warn_null_val_eliminated;

 	// Level 77
	private String sql_warn_val_trunc;

 	// Level 77
	private String sql_warn_insuff_item_descript;

 	// Level 77
	private String sql_warn_not_all_privs_granted;

 	// Level 77
	private String sql_warn_str_trunc;

 	// Level 77
	private String sql_warn_nulls_elim;

 	// Level 77
	private String sql_warn_cols_toomany;

 	// Level 77
	private String sql_warn_stmt_nowhere;

 	// Level 77
	private String sql_warn_stmt_notexec;

 	// Level 77
	private String sql_warn_date_adj;

 	// Level 77
	private String sql_warn_cursor_not_blocked;

 	// Level 77
	private String sql_warn_host_null_col_range;

 	// Level 77
	private String sql_warn_with_grant_ignored;

 	// Level 77
	private String sql_warn_char_sub;

 	// Level 77
	private String sql_warn_host_null_num_range;

 	// Level 77
	private String sql_warn_var_nownull;

 	// Level 77
	private String sql_warn_table_undef;

 	// Level 77
	private String sql_warn_nulls2_elim;

 	// Level 77
	private String sql_warn_iso_escal;

 	// Level 77
	private String sql_warn_reg_notexist;

 	// Level 77
	private String sql_warn_where_ignore;

 	// Level 77
	private String sql_warn_name_undef;

 	// Level 77
	private String sql_warn_use_sbcs_chars_only;

 	// Level 77
	private String sql_warn_op_nopriv;

 	// Level 77
	private String sql_warn_ref_ignore;

 	// Level 77
	private String sql_warn_name_interp;

 	// Level 77
	private String sql_warn_obj_nopriv;

 	// Level 77
	private String sql_warn_pack_priv;

 	// Level 77
	private String sql_warn_index_exist;

 	// Level 77
	private String sql_warn_grant_ignored;

 	// Level 77
	private String sql_warn_newlogpath_inv;

 	// Level 77
	private String sql_warn_curr_logpath_inv;

 	// Level 77
	private String sql_warn_host_null_div_zero;

 	// Level 77
	private String sql_warn_auto_check_pend_state;

 	// Level 77
	private String sql_warn_keyword_redundant;

 	// Level 77
	private String sql_warn_val_may_be_trunc;

 	// Level 77
	private String sql_warn_val_could_be_trunc;

 	// Level 77
	private String sql_warn_insuff_descriptors;

 	// Level 77
	private String sql_warn_old_view_replaced;

 	// Level 77
	private String sql_warn_no_compfunc_for_lstr;

 	// Level 77
	private String sql_warn_evmon_state_not_set;

 	// Level 77
	private String sql_warn_rebind_opts_ignored;

 	// Level 77
	private String sql_warn_conn_disabled;

 	// Level 77
	private String sql_warn_sub_optimal_query;

 	// Level 77
	private String sql_warn_constraint_vio_moved;

 	// Level 77
	private String sql_warn_explain_mode_restrict;

 	// Level 77
	private String sql_warn_possible_infinit_loop;

 	// Level 77
	private String sql_warn_dir_empty;

 	// Level 77
	private String sql_warn_timediff_exceeded;

 	// Level 77
	private String sql_warn_clause_val_replaced;

 	// Level 77
	private String sql_warn_more_result_sets;

 	// Level 77
	private String sql_warn_next_result_set;

 	// Level 77
	private String sql_warn_redist_required;

 	// Level 77
	private String sql_warn_unionall_tables_same;

 	// Level 77
	private String sql_warn_lob_changed;

 	// Level 77
	private String sql_warn_system_error;

 	// Level 77
	private String sql_warn_degree_ignored;

 	// Level 77
	private String sql_warn_one_active_buffpool;

 	// Level 77
	private String sql_warn_resource_unavail;

 	// Level 77
	private String sql_warn_invalid_cursor_pos;

 	// Level 77
	private String sql_warn_udf_returns_state;

 	// Level 77
	private String sql_nodata_exception;

 	// Level 77
	private String sql_nodata_uhole;

 	// Level 77
	private String sql_nodata_dhole;

 	// Level 77
	private String sql_inv_num_host_vars;

 	// Level 77
	private String sql_inv_parm_or_cb;

 	// Level 77
	private String sql_inv_execute_stmt;

 	// Level 77
	private String sql_using_clause_required;

 	// Level 77
	private String sql_inv_prep_stmt_cursor;

 	// Level 77
	private String sql_hostvar_not_usable;

 	// Level 77
	private String sql_conn_failed;

 	// Level 77
	private String sql_conn_already_exist;

 	// Level 77
	private String sql_conn_does_not_exit;

 	// Level 77
	private String sql_conn_rejected_by_server;

 	// Level 77
	private String sql_conn_resolution_unknown;

 	// Level 77
	private String sql_conn_failed_no_tm;

 	// Level 77
	private String sql_trigger_error;

 	// Level 77
	private String sql_proc_not_connectable;

 	// Level 77
	private String sql_lob_novalue_token_var;

 	// Level 77
	private String sql_card_value_toomany;

 	// Level 77
	private String sql_card_ins_multirow;

 	// Level 77
	private String sql_card_upd_multirow;

 	// Level 77
	private String sql_card_del_multirow;

 	// Level 77
	private String sql_data_char_rtrunc;

 	// Level 77
	private String sql_data_indicator_null;

 	// Level 77
	private String sql_data_num_range;

 	// Level 77
	private String sql_data_fetch_inv;

 	// Level 77
	private String sql_data_format_inv;

 	// Level 77
	private String sql_data_datetime_ov;

 	// Level 77
	private String sql_data_str_range;

 	// Level 77
	private String sql_data_div_zero;

 	// Level 77
	private String sql_data_inv_cast_char;

 	// Level 77
	private String sql_data_like_inv_char;

 	// Level 77
	private String sql_data_null_missing;

 	// Level 77
	private String sql_data_like_inv_esc;

 	// Level 77
	private String sql_data_length_range;

 	// Level 77
	private String sql_data_str_inv;

 	// Level 77
	private String sql_data_data_badform;

 	// Level 77
	private String sql_data_datetime_reg_inv;

 	// Level 77
	private String sql_data_type_cantuse;

 	// Level 77
	private String sql_data_type_incompat;

 	// Level 77
	private String sql_hostvar_neg_indvar;

 	// Level 77
	private String sql_data_index_dup;

 	// Level 77
	private String sql_data_str_cantuse_xlate;

 	// Level 77
	private String sql_data_str_cantasgn_xlate;

 	// Level 77
	private String sql_data_key_notequal;

 	// Level 77
	private String sql_data_ccsidval_inv;

 	// Level 77
	private String sql_data_conversion_trunc;

 	// Level 77
	private String sql_constr_chg_key_notallow;

 	// Level 77
	private String sql_constr_row_notsatisfy_view;

 	// Level 77
	private String sql_constr_null_notallow;

 	// Level 77
	private String sql_constr_value_inv;

 	// Level 77
	private String sql_constr_op_restrict;

 	// Level 77
	private String sql_constr_index_unique;

 	// Level 77
	private String sql_constr_violation_rlst;

 	// Level 77
	private String sql_constr_par_row_del_noallow;

 	// Level 77
	private String sql_constr_row_invalid;

 	// Level 77
	private String sql_constr_row_nonconform;

 	// Level 77
	private String sql_constr_violations;

 	// Level 77
	private String sql_constr_dup_key_values;

 	// Level 77
	private String sql_constr_foreign_key_noallow;

 	// Level 77
	private String sql_constr_update_cat_stats;

 	// Level 77
	private String sql_cursor_notopen;

 	// Level 77
	private String sql_cursor_open_already;

 	// Level 77
	private String sql_cursor_notpos;

 	// Level 77
	private String sql_cursor_open_no_commit;

 	// Level 77
	private String sql_cursor_pd_open;

 	// Level 77
	private String sql_cursor_deleted;

 	// Level 77
	private String sql_cursor_dhole;

 	// Level 77
	private String sql_cursor_uhole;

 	// Level 77
	private String sql_cursor_agree;

 	// Level 77
	private String sql_cursor_moved;

 	// Level 77
	private String sql_cursor_previous_error;

 	// Level 77
	private String sql_inv_execution_environment;

 	// Level 77
	private String sql_only_as_first_statement;

 	// Level 77
	private String sql_ident_notexist;

 	// Level 77
	private String sql_ident_noassoc;

 	// Level 77
	private String sql_ident_select;

 	// Level 77
	private String sql_ident_notspec;

 	// Level 77
	private String sql_ident_notsrsel;

 	// Level 77
	private String sql_ident_notselect;

 	// Level 77
	private String sql_ident_dup;

 	// Level 77
	private String sql_ident_hascursor;

 	// Level 77
	private String sql_inv_authorization_spec;

 	// Level 77
	private String sql_inv_operation_for_envir;

 	// Level 77
	private String sql_dynamic_commit_invalid;

 	// Level 77
	private String sql_dynamic_rollback_invalid;

 	// Level 77
	private String sql_inv_conn_name;

 	// Level 77
	private String sql_inv_cursor_name;

 	// Level 77
	private String sql_syntax_token_missing;

 	// Level 77
	private String sql_syntax_name_invchar;

 	// Level 77
	private String sql_syntax_str_unterm;

 	// Level 77
	private String sql_syntax_const_inv;

 	// Level 77
	private String sql_syntax_numargs_inv;

 	// Level 77
	private String sql_syntax_hconst_inv;

 	// Level 77
	private String sql_syntax_op_inv_col;

 	// Level 77
	private String sql_syntax_op_marker;

 	// Level 77
	private String sql_syntax_marker_inv;

 	// Level 77
	private String sql_syntax_col_inv;

 	// Level 77
	private String sql_syntax_stmt_bad;

 	// Level 77
	private String sql_syntax_clause_exclusive;

 	// Level 77
	private String sql_syntax_keyword_dup;

 	// Level 77
	private String sql_syntax_opt_inv;

 	// Level 77
	private String sql_syntax_stmt_empty;

 	// Level 77
	private String sql_syntax_hostvar_notallow;

 	// Level 77
	private String sql_syntax_readonly_notallow;

 	// Level 77
	private String sql_udf_returns_error_state;

 	// Level 77
	private String sql_udf_call_error;

 	// Level 77
	private String sql_udf_excute_sql_notallow;

 	// Level 77
	private String sql_udf_abnormal_end;

 	// Level 77
	private String sql_udf_interrupted;

 	// Level 77
	private String sql_udf_returns_inv_state;

 	// Level 77
	private String sql_udf_returns_result_toolong;

 	// Level 77
	private String sql_out_sqlda_changed;

 	// Level 77
	private String sql_serial_rollback;

 	// Level 77
	private String sql_rollbk_automatic;

 	// Level 77
	private String sql_stmt_completion_unknown;

 	// Level 77
	private String sql_rollbk_dist_env;

 	// Level 77
	private String sql_rollbk_conn_lost;

 	// Level 77
	private String sql_rollbk_table;

 	// Level 77
	private String sql_access_auth_notpriv_obj;

 	// Level 77
	private String sql_access_auth_notpriv_op;

 	// Level 77
	private String sql_access_auth_not_authorized;

 	// Level 77
	private String sql_access_priv_cantrevoke;

 	// Level 77
	private String sql_access_auth_fail_conn;

 	// Level 77
	private String sql_access_auth_fail_owner;

 	// Level 77
	private String sql_access_auth_fail_server;

 	// Level 77
	private String sql_access_priv_cantpublic;

 	// Level 77
	private String sql_syntax_keyword_incompat;

 	// Level 77
	private String sql_syntax_invalid;

 	// Level 77
	private String sql_invalid_char_in_name;

 	// Level 77
	private String sql_unterminated_string_const;

 	// Level 77
	private String sql_invalid_num_or_str_const;

 	// Level 77
	private String sql_invalid_num_args;

 	// Level 77
	private String sql_invalid_hex_const;

 	// Level 77
	private String sql_invalid_col_func_operand;

 	// Level 77
	private String sql_inv_use_of_null_or_dflt;

 	// Level 77
	private String sql_all_operands_parm_markers;

 	// Level 77
	private String sql_parameter_markers_invalid;

 	// Level 77
	private String sql_syntax_len_scale_inv;

 	// Level 77
	private String sql_stmt_not_in_context;

 	// Level 77
	private String sql_syntax_keyword_conflict;

 	// Level 77
	private String sql_dup_keyword_inv;

 	// Level 77
	private String sql_inv_alternative;

 	// Level 77
	private String sql_stmt_str_blank_or_empty;

 	// Level 77
	private String sql_host_var_not_allowed;

 	// Level 77
	private String sql_check_constraint_invalid;

 	// Level 77
	private String sql_name_or_label_is_too_long;

 	// Level 77
	private String sql_case_res_not_expression;

 	// Level 77
	private String sql_dup_col_in_ins_or_upd;

 	// Level 77
	private String sql_column_name_ambiguous;

 	// Level 77
	private String sql_undefined_column_name;

 	// Level 77
	private String sql_name_object_undef;

 	// Level 77
	private String sql_name_server_undefined;

 	// Level 77
	private String sql_unnamed_cols_in_result_tbl;

 	// Level 77
	private String sql_name_not_in_result_table;

 	// Level 77
	private String sql_name_dup_col_in_key;

 	// Level 77
	private String sql_name_dup_obj_name;

 	// Level 77
	private String sql_name_dup_col_name;

 	// Level 77
	private String sql_name_dup_in_from_clause;

 	// Level 77
	private String sql_name_node_not_found_in_dir;

 	// Level 77
	private String sql_name_dup_signature;

 	// Level 77
	private String sql_access_unable;

 	// Level 77
	private String sql_name_ambiguous;

 	// Level 77
	private String sql_dup_derived_table_name;

 	// Level 77
	private String sql_need_default_prim_tblspace;

 	// Level 77
	private String sql_access_duplicate_node;

 	// Level 77
	private String sql_access_undefined_node;

 	// Level 77
	private String sql_contnr_name_usedby_another;

 	// Level 77
	private String sql_contnr_name_used;

 	// Level 77
	private String sql_dup_schema_name_in_path;

 	// Level 77
	private String sql_nodegroup_not_defined;

 	// Level 77
	private String sql_num_inserts_invalid;

 	// Level 77
	private String sql_column_ref_invalid;

 	// Level 77
	private String sql_case_res_not_compatible;

 	// Level 77
	private String sql_order_by_int_not_in_result;

 	// Level 77
	private String sql_data_types_incompat;

 	// Level 77
	private String sql_operation_notpermit_on_obj;

 	// Level 77
	private String sql_column_not_updateable;

 	// Level 77
	private String sql_statement_not_applicable;

 	// Level 77
	private String sql_foreign_key_has_view;

 	// Level 77
	private String sql_num_cols_not_match_select;

 	// Level 77
	private String sql_view_notallow_with_check;

 	// Level 77
	private String sql_syntax_lang_type_inv;

 	// Level 77
	private String sql_inv_use_datatime_or_dur;

 	// Level 77
	private String sql_operands_not_compatible;

 	// Level 77
	private String sql_number_is_required;

 	// Level 77
	private String sql_num_const_out_of_range;

 	// Level 77
	private String sql_value_incompat_with_column;

 	// Level 77
	private String sql_bad_group_order_by_expr;

 	// Level 77
	private String sql_mult_cols_in_select_subq;

 	// Level 77
	private String sql_like_operand_invalid;

 	// Level 77
	private String sql_union_operands_col_incomp;

 	// Level 77
	private String sql_num_columns_do_not_match;

 	// Level 77
	private String sql_table_differs_from_cursor;

 	// Level 77
	private String sql_table_cannot_be_modified;

 	// Level 77
	private String sql_cannot_modify_result_tbl;

 	// Level 77
	private String sql_foreignkey_not_like_parent;

 	// Level 77
	private String sql_no_nulls_allowed_in_key;

 	// Level 77
	private String sql_auth_oper_sysobj_notallow;

 	// Level 77
	private String sql_null_value_notallow;

 	// Level 77
	private String sql_udf_invalid_handle_placed;

 	// Level 77
	private String sql_recurs_name_derive_tbl_inv;

 	// Level 77
	private String sql_col_attribute_incompat;

 	// Level 77
	private String sql_inv_use_of_tablespace;

 	// Level 77
	private String sql_must_use_same_tablespace;

 	// Level 77
	private String sql_as_cast_use_error;

 	// Level 77
	private String sql_parm_marker_inv_name;

 	// Level 77
	private String sql_syntax_type_opt_inv;

 	// Level 77
	private String sql_inv_bool_in_select_list;

 	// Level 77
	private String sql_inv_variant_function;

 	// Level 77
	private String sql_inv_cast;

 	// Level 77
	private String sql_privs_inv_or_inconsist;

 	// Level 77
	private String sql_syntax_type_notmatch;

 	// Level 77
	private String sql_inv_schema_name;

 	// Level 77
	private String sql_cannot_qualify_column;

 	// Level 77
	private String sql_syntax_xtern_name_inv;

 	// Level 77
	private String sql_syntax_func_src_notmatch;

 	// Level 77
	private String sql_syntax_cast_error;

 	// Level 77
	private String sql_name_schema_diff;

 	// Level 77
	private String sql_name_func_signature_undef;

 	// Level 77
	private String sql_name_func_argument_undef;

 	// Level 77
	private String sql_syntax_parm_num_notmatch;

 	// Level 77
	private String sql_table_has_no_primkey;

 	// Level 77
	private String sql_primary_key_already_exist;

 	// Level 77
	private String sql_not_unique_constraint_cols;

 	// Level 77
	private String sql_dup_unique_constraint;

 	// Level 77
	private String sql_obj_depends_on_this;

 	// Level 77
	private String sql_default_value_inv;

 	// Level 77
	private String sql_syntax_hostvar_type_incomp;

 	// Level 77
	private String sql_inv_correlation_ref;

 	// Level 77
	private String sql_correlation_ref_not_allow;

 	// Level 77
	private String sql_error_in_udf;

 	// Level 77
	private String sql_noaccess_hostfile_var_file;

 	// Level 77
	private String sql_access_part_null;

 	// Level 77
	private String sql_evmon_bad_path_specified;

 	// Level 77
	private String sql_evmon_bad_option_specified;

 	// Level 77
	private String sql_inv_exception_table;

 	// Level 77
	private String sql_excep_tbl_same_as_chk_tbl;

 	// Level 77
	private String sql_num_check_tbls_mismatch;

 	// Level 77
	private String sql_parent_tbl_in_chck_pend_st;

 	// Level 77
	private String sql_access_invalid_range;

 	// Level 77
	private String sql_illegal_elmnt_nstng;

 	// Level 77
	private String sql_incorrect_num_on_nodes;

 	// Level 77
	private String sql_contnr_path_nm_not_valid;

 	// Level 77
	private String sql_inv_sqlstate_from_app;

 	// Level 77
	private String sql_drop_only_node;

 	// Level 77
	private String sql_num_elements_no_match;

 	// Level 77
	private String sql_datatype_mapping_not_found;

 	// Level 77
	private String sql_col_func_needs_col_name;

 	// Level 77
	private String sql_object_also_in_from_clause;

 	// Level 77
	private String sql_where_or_set_has_inv_ref;

 	// Level 77
	private String sql_string_is_too_long;

 	// Level 77
	private String sql_column_list_missing;

 	// Level 77
	private String sql_invalid_decimal_divide;

 	// Level 77
	private String sql_column_not_in_upd_clause;

 	// Level 77
	private String sql_update_or_delete_invalid;

 	// Level 77
	private String sql_table_in_subquery_affected;

 	// Level 77
	private String sql_inv_referential_constraint;

 	// Level 77
	private String sql_rep_chain_alias_invalid;

 	// Level 77
	private String sql_cannot_explicitly_drop_obj;

 	// Level 77
	private String sql_name_reserved;

 	// Level 77
	private String sql_cannot_add_containers;

 	// Level 77
	private String sql_rec_name_der_tlb_spec_inv;

 	// Level 77
	private String sql_prog_assumptions_incorrect;

 	// Level 77
	private String sql_auth_create_sysobj_noallow;

 	// Level 77
	private String sql_inv_use_long_column;

 	// Level 77
	private String sql_no_sw_license;

 	// Level 77
	private String sql_package_not_created;

 	// Level 77
	private String sql_inv_join_condition;

 	// Level 77
	private String sql_inv_conn_reset;

 	// Level 77
	private String sql_stmt_inv_for_storproc_trig;

 	// Level 77
	private String sql_syntax_system_use_only;

 	// Level 77
	private String sql_lob_col_too_big_to_log;

 	// Level 77
	private String sql_raw_device_not_supp;

 	// Level 77
	private String sql_unique_not_allowed;

 	// Level 77
	private String sql_inv_fk_ref;

 	// Level 77
	private String sql_inv_nodegroup;

 	// Level 77
	private String sql_datajoiner_no_process;

 	// Level 77
	private String sql_inv_notloginit;

 	// Level 77
	private String sql_view_def_not_satisfied;

 	// Level 77
	private String sql_state_call_inv;

 	// Level 77
	private String sql_state_package_notfound;

 	// Level 77
	private String sql_state_tokens_notmatch;

 	// Level 77
	private String sql_state_addr_inv_da;

 	// Level 77
	private String sql_state_func_disabled;

 	// Level 77
	private String sql_state_stmt_notexec;

 	// Level 77
	private String sql_state_release_inv;

 	// Level 77
	private String sql_state_proc_notconnectable;

 	// Level 77
	private String sql_state_section_binderr;

 	// Level 77
	private String sql_state_user_notloggedon;

 	// Level 77
	private String sql_state_app_unconnected;

 	// Level 77
	private String sql_state_crtpack_busy;

 	// Level 77
	private String sql_state_pack_none;

 	// Level 77
	private String sql_rollback_required;

 	// Level 77
	private String sql_conn_with_auth_already;

 	// Level 77
	private String sql_state_db_inuse_anoth_inst;

 	// Level 77
	private String sql_inoperaitve_view;

 	// Level 77
	private String sql_conn_settings_in_use;

 	// Level 77
	private String sql_evmon_path_inuse;

 	// Level 77
	private String sql_immediate_checked_opt_inv;

 	// Level 77
	private String sql_package_inoperative;

 	// Level 77
	private String sql_name_col_dup_stmt;

 	// Level 77
	private String sql_name_colref_dup_name;

 	// Level 77
	private String sql_name_col_undef;

 	// Level 77
	private String sql_name_obj_undef;

 	// Level 77
	private String sql_name_server_undef;

 	// Level 77
	private String sql_name_col_inv;

 	// Level 77
	private String sql_name_col_notresult;

 	// Level 77
	private String sql_name_cursor_undef;

 	// Level 77
	private String sql_name_col_dup_keyclause;

 	// Level 77
	private String sql_name_obj_dup;

 	// Level 77
	private String sql_name_col_dup_objdef;

 	// Level 77
	private String sql_name_table_dup;

 	// Level 77
	private String sql_name_cursor_dup;

 	// Level 77
	private String sql_name_cursor_notqual;

 	// Level 77
	private String sql_name_colref_dup_set;

 	// Level 77
	private String sql_name_as_noname;

 	// Level 77
	private String sql_name_cursor_undecl;

 	// Level 77
	private String sql_name_node_notfound;

 	// Level 77
	private String sql_name_reg_unknown;

 	// Level 77
	private String sql_ospec_numval_notsame;

 	// Level 77
	private String sql_ospec_column_inv;

 	// Level 77
	private String sql_ospec_clause_notcolumn;

 	// Level 77
	private String sql_ospec_op_notpermit;

 	// Level 77
	private String sql_ospec_col_notupdatable;

 	// Level 77
	private String sql_ospec_obj_wrongtype;

 	// Level 77
	private String sql_ospec_clause_isview;

 	// Level 77
	private String sql_ospec_numcol_notsame;

 	// Level 77
	private String sql_ospec_option_bad;

 	// Level 77
	private String sql_ospec_data_inv;

 	// Level 77
	private String sql_ospec_datetime_inv_expr;

 	// Level 77
	private String sql_ospec_numvar_notsame;

 	// Level 77
	private String sql_ospec_operands_notcompat;

 	// Level 77
	private String sql_ospec_op_notnumb;

 	// Level 77
	private String sql_ospec_cons_toolong;

 	// Level 77
	private String sql_ospec_val_notcompat_col;

 	// Level 77
	private String sql_ospec_clause_toomany;

 	// Level 77
	private String sql_ospec_likeop_bad;

 	// Level 77
	private String sql_ospec_unionop_incompat_col;

 	// Level 77
	private String sql_ospec_unionop_badnum_col;

 	// Level 77
	private String sql_ospec_table_notsame_cursor;

 	// Level 77
	private String sql_ospec_table_cantmodify;

 	// Level 77
	private String sql_ospec_update_inv_rotable;

 	// Level 77
	private String sql_ospec_fkey_notconform;

 	// Level 77
	private String sql_ospec_null_notallow;

 	// Level 77
	private String sql_ospec_op_notallow_sysobj;

 	// Level 77
	private String sql_ospec_fkey_notallow_null;

 	// Level 77
	private String sql_ospec_col_inv;

 	// Level 77
	private String sql_ospec_priv_inv;

 	// Level 77
	private String sql_ospec_opt_both;

 	// Level 77
	private String sql_ospec_auth_bad;

 	// Level 77
	private String sql_ospec_stmt_cantuse;

 	// Level 77
	private String sql_ospec_db_cantuse;

 	// Level 77
	private String sql_ospec_stmt_cantexec;

 	// Level 77
	private String sql_ospec_hostvar_undef;

 	// Level 77
	private String sql_ospec_info_notmatch;

 	// Level 77
	private String sql_ospec_options_conflict;

 	// Level 77
	private String sql_ospec_descriptors_toofew;

 	// Level 77
	private String sql_ospec_numstructs_notmatch;

 	// Level 77
	private String sql_ospec_clause_incompat;

 	// Level 77
	private String sql_ospec_numrows_inv;

 	// Level 77
	private String sql_limit_stmt_toolong;

 	// Level 77
	private String sql_limit_sconst_toolong;

 	// Level 77
	private String sql_limit_name_toolong;

 	// Level 77
	private String sql_limit_names_toomany;

 	// Level 77
	private String sql_limit_concat_toolong;

 	// Level 77
	private String sql_limit_as_toobig;

 	// Level 77
	private String sql_limit_key_toolong;

 	// Level 77
	private String sql_limit_table_toolong;

 	// Level 77
	private String sql_limit_cols_toomany;

 	// Level 77
	private String sql_limit_descriptors_toomany;

 	// Level 77
	private String sql_limit_arguments_toomany;

 	// Level 77
	private String sql_limit_concur_lob_handles;

 	// Level 77
	private String sql_limit_open_dir_scans;

 	// Level 77
	private String sql_limit_evmon_toomany;

 	// Level 77
	private String sql_limit_evtfiles_toomany;

 	// Level 77
	private String sql_limit_max_table_size;

 	// Level 77
	private String sql_limit_pmap_toomany;

 	// Level 77
	private String sql_limit_contnr_names_len;

 	// Level 77
	private String sql_limit_tblspace_size;

 	// Level 77
	private String sql_limit_contnr_path_len;

 	// Level 77
	private String sql_limit_contain_map_complx;

 	// Level 77
	private String sql_limit_cascaded_triggers;

 	// Level 77
	private String sql_limit_container_size;

 	// Level 77
	private String sql_limit_transition_tbl;

 	// Level 77
	private String sql_state_db_notmigr;

 	// Level 77
	private String sql_state_expl_tbl_not_defined;

 	// Level 77
	private String sql_state_obj_inuse;

 	// Level 77
	private String sql_state_obj_notalter;

 	// Level 77
	private String sql_state_table_nokey;

 	// Level 77
	private String sql_state_file_readonly;

 	// Level 77
	private String sql_state_obj_hasdeps;

 	// Level 77
	private String sql_state_table_haskey;

 	// Level 77
	private String sql_state_table_invalid;

 	// Level 77
	private String sql_state_refresh_running;

 	// Level 77
	private String sql_chk_constraint_too_long;

 	// Level 77
	private String sql_state_db_needrestart;

 	// Level 77
	private String sql_trigger_def_too_long;

 	// Level 77
	private String sql_state_os2_reserved;

 	// Level 77
	private String sql_conn_inv_dbm_stopped;

 	// Level 77
	private String sql_must_commit_for_evmon;

 	// Level 77
	private String sql_evmon_active_cant_drop;

 	// Level 77
	private String sql_state_drop_part_key;

 	// Level 77
	private String sql_state_rebalancing;

 	// Level 77
	private String sql_inv_state_change;

 	// Level 77
	private String sql_rebalance_in_progress;

 	// Level 77
	private String sql_misc_noname;

 	// Level 77
	private String sql_misc_from_inv;

 	// Level 77
	private String sql_misc_where_inv;

 	// Level 77
	private String sql_misc_distinct_toomany;

 	// Level 77
	private String sql_misc_str_toolong;

 	// Level 77
	private String sql_misc_list_missing;

 	// Level 77
	private String sql_misc_divide_neg;

 	// Level 77
	private String sql_misc_col_noupdate;

 	// Level 77
	private String sql_misc_upddel_inv;

 	// Level 77
	private String sql_misc_del_inv;

 	// Level 77
	private String sql_misc_constr_inv;

 	// Level 77
	private String sql_misc_object_nodrop;

 	// Level 77
	private String sql_misc_inv_comm_roll;

 	// Level 77
	private String sql_misc_ref_inv;

 	// Level 77
	private String sql_misc_alias_nottable;

 	// Level 77
	private String sql_misc_op_inv;

 	// Level 77
	private String sql_misc_mixed_dbcs_inv;

 	// Level 77
	private String sql_misc_prep_inv;

 	// Level 77
	private String sql_misc_obj_notcrt;

 	// Level 77
	private String sql_misc_package_notcommit;

 	// Level 77
	private String sql_misc_name_notid;

 	// Level 77
	private String sql_misc_data_notsupp;

 	// Level 77
	private String sql_misc_stmt_notexec;

 	// Level 77
	private String sql_misc_name_notmatch;

 	// Level 77
	private String sql_misc_iso_notuser;

 	// Level 77
	private String sql_misc_join_badcols;

 	// Level 77
	private String sql_misc_name_required;

 	// Level 77
	private String sql_misc_name_notqual;

 	// Level 77
	private String sql_lob_nosupp_in_drda;

 	// Level 77
	private String sql_misc_n_a_compound_sql_err;

 	// Level 77
	private String sql_misc_name_both_user_group;

 	// Level 77
	private String sql_misc_no_blob_in_dwnlvl_cl;

 	// Level 77
	private String sql_misc_not_aligned;

 	// Level 77
	private String sql_misc_prep_rebind_inv;

 	// Level 77
	private String sql_misc_real_not_supported;

 	// Level 77
	private String sql_misc_lob_action_failed;

 	// Level 77
	private String sql_rsrc_pending;

 	// Level 77
	private String sql_rsrc_vsdb_tunavail;

 	// Level 77
	private String sql_rsrc_vsdb_unavail;

 	// Level 77
	private String sql_rsrc_nondb_unavail_cont;

 	// Level 77
	private String sql_rsrc_nondb_unavail_stop;

 	// Level 77
	private String sql_rsrc_cancel;

 	// Level 77
	private String sql_rsrc_table_inactive;

 	// Level 77
	private String sql_rsrc_cxlate_notdef;

 	// Level 77
	private String sql_rsrc_drive_notexist;

 	// Level 77
	private String sql_rsrc_drive_locked;

 	// Level 77
	private String sql_rsrc_drive_open;

 	// Level 77
	private String sql_rsrc_maxapps;

 	// Level 77
	private String sql_rsrc_maxdb;

 	// Level 77
	private String sql_rsrc_db_started;

 	// Level 77
	private String sql_rsrc_db_acquired;

 	// Level 77
	private String sql_rsrc_dbfile_notown;

 	// Level 77
	private String sql_rsrc_log_notown;

 	// Level 77
	private String sql_rsrc_standalone;

 	// Level 77
	private String sql_rsrc_quiesce_backup;

 	// Level 77
	private String sql_rsrc_dir_not_access;

 	// Level 77
	private String sql_rsrc_contnr_acc_err;

 	// Level 77
	private String sql_rsrc_sys_limit;

 	// Level 77
	private String sql_rsrc_path;

 	// Level 77
	private String sql_rsrc_unavail_node;

 	// Level 77
	private String sql_rsrc_disk_stuffit;

 	// Level 77
	private String sql_rsrc_disk_bad;

 	// Level 77
	private String sql_rsrc_disk_full;

 	// Level 77
	private String sql_syserr_inv_sect;

 	// Level 77
	private String sql_syserr_err_cont;

 	// Level 77
	private String sql_syserr_err_stop;

 	// Level 77
	private String sql_syserr_dist_cont;

 	// Level 77
	private String sql_syserr_dist_dealloc;

 	// Level 77
	private String sql_syserr_dist_stop;

 	// Level 77
	private String sql_syserr_bind_active;

 	// Level 77
	private String sql_syserr_bind_inactive;

 	// Level 77
	private String sql_syserr_cmd_notsupp;

 	// Level 77
	private String sql_syserr_obj_notsupp;

 	// Level 77
	private String sql_syserr_param_notsupp;

 	// Level 77
	private String sql_syserr_value_notsupp;

 	// Level 77
	private String sql_syserr_msg_notsupp;

 	// Level 77
	private String sql_syserr_commerr;

 	// Level 77
	private String sql_syserr_notdef;

 	// Level 77
	private String sql_syserr_prog_canceled;

 	// Level 77
	private String sql_syserr_hostvars;

 	// Level 77
	private String sql_syserr_ioerr;

 	// Level 77
	private String sql_syserr_dbfile;

 	// Level 77
	private String sql_syserr_str_fenced_fun_fail;

 	// Level 77
	private String sql_syserr_find_tbsp_pg_fail;

 	// Level 77
	private String sql_syserr_free_tbsp_pg_fail;

 	// Level 77
	private String sql_syserr_tblspc_id_noexist;

 	// Level 01
	private String csxxs020;

 	// Level 01
	private String csxxc920_max_accumerrors_len;

 	// Level 01
	private String csxxc920_errornum;

 	// Level 01
	private String csxxc920_environment;

 	// Level 01
	private String csxxc920_association;

 	// Level 01
	private String csxxc920_subval1;

 	// Level 01
	private String csxxc920_subval2;

 	// Level 01
	private String csxxc920_subval3;

 	// Level 01
	private String ws_pi_function;

 	// Level 01
	private String ws_pi_param;

 	// Level 03
	private String ws_pi_size;

 	// Level 03
	private String ws_pi_flags;

 	// Level 03
	private String ws_pi_handle;

 	// Level 03
	private String ws_pi_prog_id;

 	// Level 03
	private String ws_pi_gpi_attrs;

 	// Level 01
	private String ws_pi_name_buf;

 	// Level 01
	private String ws_pi_name_len;

 	
 	// Level 05
	private String wbsrc09b_input;

	// Level 01
	private InItem[] wbsrc09b_parms = new InItem[]{ () -> wbsrc09b_input };
 	// Level 05
	private String wbsrc09b_output;

	// Level 10
	private InItem[] filler = new InItem[]{ () -> wbsrc09b_output };
 	// Level 10
	private String wbsrc09b_carr_ownr_cd;

 	// Level 10
	private String wbsrc09b_carr_mrk;

 	// Level 10
	private String wbsrc09b_co_name;

 	// Level 10
	private String wbsrc09b_mcs_impl_lvl;

 	// Level 10
	private String wbsrc09b_next_ch_run_tmstmp;

 	// Level 10
	private String wbsrc09b_last_ch_run_tmstmp;

 	// Level 10
	private String wbsrc09b_create_tmstmp;

 	// Level 10
	private String wbsrc09b_create_pgm_name;

 	// Level 10
	private String wbsrc09b_create_userid;

 	// Level 10
	private String wbsrc09b_last_updt_tmstmp;

 	// Level 10
	private String wbsrc09b_last_updt_pgm_name;

 	// Level 10
	private String wbsrc09b_last_updt_userid;

 	// Level 10
	private String wbsrc09b_cstm_scac;

 	// Level 10
	private String wbsrc09b_wayb_manl_vrf_flag;

 	// Level 10
	private String wbsrc09b_us_scrty_alrt_lvl;

 	// Level 10
	private String wbsrc09b_wb_tmplt_exec_flg;

 	// Level 10
	private String wbsrc09b_extrnl_rev_sys_ind;

 	// Level 10
	private String wbsrc09b_eff_dt;

 	// Level 10
	private String wbsrc09b_exp_dt;

 	// Level 10
	private String wbsrc09b_prev_carr_mrk;

 	// Level 10
	private String wbsrc09b_prev_r260_carr_id;

 	// Level 10
	private String wbsrc09b_exp_area;

 	// Level 01
	private String csxxc020_stack_size;

 	// Level 01
	private String csxxc020_error_severity;

 	// Level 01
	private String csxxc020_error_text;

 	// Level 49
	private String csxxc020_error_text_len;

 	// Level 49
	private String csxxc020_error_text_msg;

 	// Level 01
	private String csxxc020_err_handler_rtncd;


    public static void main(String[] args) {
        try {
            WBSRS009 instance = new WBSRS009();
            instance.m_procdiv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m_procdiv () throws Exception {
    }
    public void m_0000_common_init () throws Exception {
        
        
        
        
        if ( ws-pi-name-buf(10:1) == "s" ) {
		}
        if ( csxxc020-error-severity<0 ) {
			Display.display( ws_pi_name_buf );
			Display.display( " initialized" );
		} else {
			Display.display( ws_pi_name_buf );
			Display.display( "**not**initialized" );
		}
        
        
        if ( csxxc020-stack-size == 0 ) {
		}
        
        
        
    }
    public void m_0000_process () throws Exception {
         m_1000_initialize();
         m_2000_process();
         m_9999_return_to_caller();
    }
    public void m_1000_initialize () throws Exception {
        
         m_9999_db2_connect();
        
        
    }
    public void m_2000_process () throws Exception {
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
         m_9999_db2_unexpected_error();
    }
    public void m_9999_db2_unexpected_error () throws Exception {
        
         m_9999_getsqlstatetext();
        
        
         m_9999_unexpected_error();
    }
    public void m_9999_unexpected_error () throws Exception {
         m_9999_mcs_error_handler();
         m_9999_return_to_caller();
    }
    public void m_9999_terminate_for_error () throws Exception {
         m_9999_return_to_caller();
    }
    public void m_9999_return_to_caller () throws Exception {
         m_9999_db2_disconnect();
    }
    public void m_9999_mcs_error_handler () throws Exception {
         m_9999_terminate_for_error();
    }
    public void m_9999_getsqlstatetext () throws Exception {
    }
    public void m_9999_db2_disconnect () throws Exception {
    }
}
