################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../depth-first-tree/tree.c 

OBJS += \
./depth-first-tree/tree.o 

C_DEPS += \
./depth-first-tree/tree.d 


# Each subdirectory must supply rules for building sources it contributes
depth-first-tree/%.o: ../depth-first-tree/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


