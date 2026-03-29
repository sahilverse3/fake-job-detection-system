class JobAnalyzer {

    String analyze(Job job) {
        int risk = 0;

        if (job.company == null || job.company.isEmpty()) {
            risk += 2;
        }

        if (!job.email.contains("@")) {
            risk += 2;
        }

        if (job.asksMoney) {
            risk += 3;
        }

        if (job.salary > 100000) {
            risk += 2;
        }

        if (job.description.length() < 20) {
            risk += 1;
        }

        if (risk >= 6) {
            return "Highly Risky";
        } 
        else if (risk >= 3) {
            return "Suspicious";
        } 
        else {
            return "Safe";
        }
    }
}