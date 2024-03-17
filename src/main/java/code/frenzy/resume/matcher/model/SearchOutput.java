package code.frenzy.resume.matcher.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SearchOutput {

    private List<Value> value;
}
