package com.itcomp.records;

import com.itcomp.enums.TaskPriority;

public record TaskReport(
        String title,
        TaskPriority priority,
        boolean completed
) {
}
