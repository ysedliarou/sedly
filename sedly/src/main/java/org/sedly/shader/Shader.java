package org.sedly.shader;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;

public class Shader {

    private int program;

    public Shader() {
        program = glCreateProgram();

        if (program == 0) {
            throw new ShaderException("create");
        }
    }

    public void addVertexShader(String string) {
        addShader(string, GL_VERTEX_SHADER);
    }

    public void addFragmentShader(String string) {
        addShader(string, GL_FRAGMENT_SHADER);
    }

    public void addGeometryShader(String string) {
        addShader(string, GL_GEOMETRY_SHADER);
    }

    private void addShader(String string, int type) {

        int shader = glCreateShader(type);

        if (shader == 0) {
            throw new ShaderException("add");
        }

        glShaderSource(shader, string);
        glCompileShader(shader);

        if (glGetShader(program, GL_COMPILE_STATUS) == 0) {
            throw new ShaderException(glGetShaderInfoLog(shader, 1024));
        }

        glAttachShader(program, shader);

    }

    public void compile() {

        glLinkProgram(program);

        if (glGetProgram(program, GL_LINK_STATUS) == 0) {
            throw new ShaderException(glGetProgramInfoLog(program, 1024));
        }

        glValidateProgram(program);
        if (glGetProgram(program, GL_VALIDATE_STATUS) == 0) {
            throw new ShaderException(glGetProgramInfoLog(program, 1024));
        }
    }

    public void bind() {
        glUseProgram(program);
    }

}
