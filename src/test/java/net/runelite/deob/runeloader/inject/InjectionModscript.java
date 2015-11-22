package net.runelite.deob.runeloader.inject;

import com.google.common.io.Files;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.objectweb.asm.tree.AbstractInsnNode;

public class InjectionModscript {
   private List getterInjects = new LinkedList();
   private List superChangeInjects = new LinkedList();
   private List addInterfaceInjects = new LinkedList();
   private List methodMods = new LinkedList();
   private List addMethods = new LinkedList();
   private List newMethodMods = new LinkedList();

   public void save() {
      byte[] var1 = (new GsonBuilder()).setPrettyPrinting().create().toJson(this).getBytes();

      try {
         Files.write(var1, new File("injection.json"));
      } catch (IOException var3) {
         var3.printStackTrace();
      }

   }

   public static InjectionModscript load(File var0) throws IOException {
      byte[] var1 = Files.toByteArray(var0);
      return (InjectionModscript)(new GsonBuilder()).registerTypeAdapter(AbstractInsnNode.class, new InstructionDeserializer()).create().fromJson((new String(var1)).replaceAll("runecore", "runeloader"), InjectionModscript.class);
   }

   public List getGetterInjects() {
      return this.getterInjects;
   }

   public List getSuperChangeInjects() {
      return this.superChangeInjects;
   }

   public List getAddInterfaceInjects() {
      return this.addInterfaceInjects;
   }

   public List getMethodMods() {
      return this.methodMods;
   }

   public List getAddMethods() {
      return this.addMethods;
   }

   public List getNewMethodMods() {
      return this.newMethodMods;
   }
}
